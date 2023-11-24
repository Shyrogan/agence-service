package fr.samyseb.hotelservice.services;

import fr.samyseb.hotelservice.pojos.Offre;
import fr.samyseb.hotelservice.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class OffreService {

    private final AgenceService agenceService;
    private final HotelRepository hotelRepository;

    public List<Offre> create(LocalDate debut, LocalDate fin) {
        return StreamSupport.stream(hotelRepository.findAll().spliterator(), true)
                .map(hotel -> WebClient.create()
                        .post()
                        .uri(format("%s/offre", hotel.url()))
                        .header("Authorization",
                                format("Basic %s:%s", agenceService.identity().id(),
                                        agenceService.identity().motDePasse()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(Mono.just(Offre.builder()
                                .debut(debut)
                                .fin(fin)
                                .build()), Offre.class)
                        .retrieve()
                        .bodyToMono(new ParameterizedTypeReference<List<Offre>>() {
                        })
                        .block())
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
