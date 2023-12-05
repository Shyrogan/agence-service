package fr.samyseb.hotelservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "carteBancaire")
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
    @OneToOne(cascade = CascadeType.ALL)
    @Getter(onMethod = @__(@JsonIgnore))
    private Client client;

}
