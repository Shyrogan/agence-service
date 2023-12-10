package fr.samyseb.hotelservice.controllers;

import fr.samyseb.hotelservice.pojos.Offre;
import fr.samyseb.hotelservice.services.ConsultationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/consultation")
@RequiredArgsConstructor
public class ConsultationController {

    private final ConsultationService consultationService;

    @GetMapping
    public List<Offre> getOffres(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate debut,
                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin,
                                 @RequestParam(required = false) Float prixMin,
                                 @RequestParam(required = false) Float prixMax,
                                 @RequestParam(required = false) Integer etoilesMin) {
        return consultationService.create(debut, fin, prixMin, prixMax,etoilesMin);
    }


}
