package fr.samyseb.hotelservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chambre")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter(onMethod = @__(@JsonProperty))
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private long numero;
    private float prix;
    private int places;
    @ManyToOne
    @Getter(onMethod = @__(@JsonIgnore))
    private Hotel hotel;
    @Lob
    @Getter(onMethod = @__(@JsonIgnore))
    private byte[] image;
    @OneToMany
    @Getter(onMethod = @__(@JsonIgnore))
    private List<Reservation> reservations;

}