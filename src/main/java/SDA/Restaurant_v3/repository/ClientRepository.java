package SDA.Restaurant_v3.repository;

import SDA.Restaurant_v3.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

   Optional<ClientModel> findByEmail (String email);
}
