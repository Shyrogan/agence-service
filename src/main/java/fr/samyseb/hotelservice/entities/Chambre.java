package fr.samyseb.hotelservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "chambre")
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
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private Hotel hotel;
    @OneToMany
    @Getter(onMethod = @__(@JsonIgnore))
    private List<Reservation> reservations;

}
