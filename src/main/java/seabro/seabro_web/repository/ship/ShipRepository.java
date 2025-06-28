package seabro.seabro_web.repository.ship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import seabro.seabro_web.domain.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
