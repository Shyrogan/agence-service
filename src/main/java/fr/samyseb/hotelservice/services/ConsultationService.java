package fr.samyseb.hotelservice.services;

import fr.samyseb.hotelservice.pojos.Offre;
import fr.samyseb.hotelservice.repositories.HotelRepository;
import fr.samyseb.hotelservice.repositories.PartenariatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ConsultationService {

    private final AgenceService agenceService;
    private final HotelRepository hotelRepository;
    private final PartenariatRepository partenariatRepository;

    public List<Offre> create(LocalDate debut, LocalDate fin, Float prixMin, Float prixMax) {
        return StreamSupport.stream(hotelRepository.findAll().spliterator(), true)
                .map(hotel -> WebClient.create()
                        .get()
                        .uri(b -> b.scheme(hotel.url().getProtocol())
                                .host(hotel.url().getHost())
                                .path("/consultation")
                                .port(hotel.url().getPort())
                                .queryParam("debut", debut)
                                .queryParam("fin", fin)
                                .queryParam("prixMin", prixMin)
                                .queryParam("prixMax", prixMax)
                                .build())
                        .header("Authorization", agenceService.authorization())
                        .retrieve()
                        .bodyToMono(Offre[].class)
                        .block())
                .map(this::reductions)
                .filter(Objects::nonNull)
                .flatMap(Arrays::stream)

                .collect(Collectors.toList());
    }

    private Offre[] reductions(Offre[] offres) {
        if (offres == null || offres.length == 0) return offres;

        final var hotel = offres[0].hotel();
        final var partenariat = partenariatRepository.findFirstByHotelAndAgence(hotel, agenceService.identity());
        if (partenariat == null) return offres;

        for (var o : offres) {
            o.prixSejour(o.prixSejour() * partenariat.reduction());
        }
        return offres;
    }

}
