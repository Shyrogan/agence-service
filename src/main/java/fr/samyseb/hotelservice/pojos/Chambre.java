package fr.samyseb.hotelservice.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter(onMethod = @__(@JsonProperty))
public class Chambre {

    // On ne génère pas l'id
    @Id
    private long numero;
    private float prix;
    private int places;

}
