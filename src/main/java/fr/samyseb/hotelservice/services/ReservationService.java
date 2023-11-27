package fr.samyseb.hotelservice.services;

import fr.samyseb.hotelservice.entities.Client;
import fr.samyseb.hotelservice.entities.Reservation;
import fr.samyseb.hotelservice.pojos.Offre;
import fr.samyseb.hotelservice.pojos.ReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final AgenceService agenceService;

    public Reservation reserver(Offre offre, Client fillableClient) {
        return WebClient.create()
                .post()
                .uri(format("%s/reservation", offre.hotel().url()))
                .header("Authorization", agenceService.authorization())
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(ReservationRequest.builder()
                        .offre(offre)
                        .client(fillableClient)
                        .build()), Reservation.class)
                .retrieve()
                .bodyToMono(Reservation.class)
                .block();
    }

}
