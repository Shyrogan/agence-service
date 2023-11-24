package fr.samyseb.hotelservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "adresse")
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
