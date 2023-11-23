package fr.samyseb.hotelservice.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter(onMethod = @__(@JsonProperty))
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String numero;
    private String rue;
    private String ville;
    private String pays;

}
