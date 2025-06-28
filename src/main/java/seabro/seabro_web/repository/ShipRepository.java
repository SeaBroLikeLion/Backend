package seabro.seabro_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seabro.seabro_web.domain.Ship;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

}
