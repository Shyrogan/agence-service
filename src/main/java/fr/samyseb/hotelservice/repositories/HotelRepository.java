package fr.samyseb.hotelservice.repositories;

import fr.samyseb.hotelservice.entities.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, UUID> {
}
