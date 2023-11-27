package fr.samyseb.hotelservice.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.samyseb.hotelservice.entities.Agence;
import fr.samyseb.hotelservice.entities.Chambre;
import fr.samyseb.hotelservice.entities.Hotel;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter(onMethod = @__(@JsonProperty))
public class Offre {

    private Agence agence;
    private Hotel hotel;
    private float prixSejour;
    private Chambre chambre;
    private LocalDate debut;
    private LocalDate fin;

}
