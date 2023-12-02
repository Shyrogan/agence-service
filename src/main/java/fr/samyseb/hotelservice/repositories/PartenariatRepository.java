package fr.samyseb.hotelservice.repositories;

import fr.samyseb.hotelservice.entities.Agence;
import fr.samyseb.hotelservice.entities.Partenariat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartenariatRepository extends CrudRepository<Partenariat, UUID> {

    void deleteAllByAgence(Agence agence);

}
