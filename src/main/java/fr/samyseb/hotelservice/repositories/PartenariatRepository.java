package fr.samyseb.hotelservice.repositories;

import fr.samyseb.hotelservice.entities.Agence;
import fr.samyseb.hotelservice.entities.Hotel;
import fr.samyseb.hotelservice.entities.Partenariat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PartenariatRepository extends CrudRepository<Partenariat, UUID> {

    Partenariat findFirstByHotelAndAgence(Hotel hotel, Agence agence);

    void deleteAllByAgence(Agence agence);

}
