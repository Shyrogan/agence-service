package fr.samyseb.hotelservice.services;

import fr.samyseb.hotelservice.pojos.Client;
import fr.samyseb.hotelservice.pojos.Offre;
import fr.samyseb.hotelservice.pojos.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    public Reservation reserver(Offre offre, Client fillableClient) {
        return null;
    }

}
