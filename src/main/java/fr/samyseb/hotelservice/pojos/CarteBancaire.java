package fr.samyseb.hotelservice.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter(onMethod = @__(@JsonProperty))
public class CarteBancaire {

    @Id
    @Column(length = 20)
    private String numero;
    private int mois;
    private int annee;
    @Column(length = 3)
    private String cryptogramme;

}
