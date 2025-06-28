package seabro.seabro_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seabro.seabro_web.domain.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByShip_ShipIdAndDate(Long shipId, LocalDate date);
}
