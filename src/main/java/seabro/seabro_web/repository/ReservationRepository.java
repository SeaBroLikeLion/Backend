package seabro.seabro_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seabro.seabro_web.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
