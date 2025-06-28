package seabro.seabro_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seabro.seabro_web.domain.Ship;

public interface ShipRepository extends JpaRepository<Ship, Long> {
    // 필요한 커스텀 메서드가 있으면 여기에 추가
}
