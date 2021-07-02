package SDA.Restaurant_v3.repository;

import SDA.Restaurant_v3.entities.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Long> {
}
