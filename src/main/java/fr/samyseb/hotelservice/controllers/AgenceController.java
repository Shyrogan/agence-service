package fr.samyseb.hotelservice.controllers;

import fr.samyseb.hotelservice.entities.Agence;
import fr.samyseb.hotelservice.services.AgenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AgenceController {

    private final AgenceService agenceService;

    @GetMapping("/")
    public Agence getAgenceMetadata() {
        return agenceService.identity();
    }

}
