package fr.samyseb.hotelservice.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.samyseb.hotelservice.entities.Client;
import fr.samyseb.hotelservice.entities.Reservation;
import fr.samyseb.hotelservice.pojos.Offre;
import fr.samyseb.hotelservice.services.ReservationService;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public Reservation createReservation(@RequestBody ReservationRequest request) {
        return reservationService.reserver(request.offre(), request.client());
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter(onMethod = @__(@JsonProperty))
    public static class ReservationRequest {
        private Offre offre;
        private Client client;
    }

}
