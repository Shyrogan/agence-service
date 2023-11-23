package fr.samyseb.hotelservice.services;

import fr.samyseb.hotelservice.pojos.Offre;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class OffreService {

    public List<Offre> create(LocalDate debut, LocalDate fin) {
        return Collections.emptyList();
    }

}
