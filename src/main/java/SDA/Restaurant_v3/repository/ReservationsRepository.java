package SDA.Restaurant_v3.repository;

import SDA.Restaurant_v3.entities.ReservationsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<ReservationsModel, Long> {
}
