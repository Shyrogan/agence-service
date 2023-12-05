package fr.samyseb.hotelservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "agence")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter(onMethod = @__(@JsonProperty))
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nom;
    private String motDePasse;
    private URL url;
    @OneToMany(mappedBy = "agence")
    @Getter(onMethod = @__(@JsonIgnore))
    @JsonIgnore
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "agence")
    @Getter(onMethod = @__(@JsonIgnore))
    private List<Partenariat> partenariats;

}
