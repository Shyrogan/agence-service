package fr.samyseb.hotelservice.controllers;

import fr.samyseb.hotelservice.entities.Reservation;
import fr.samyseb.hotelservice.pojos.ReservationRequest;
import fr.samyseb.hotelservice.services.ReservationService;
import lombok.RequiredArgsConstructor;
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

}
