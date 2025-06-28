package seabro.seabro_web.service;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.schedule.ScheduleSearchCond;
import seabro.seabro_web.repository.ship.ShipDto;

import java.util.List;
import java.util.Optional;

public interface ShipService {
    ShipDto saveShip(ShipDto shipDto);

    ShipDto updateShip(Long shipId, ShipDto updateParam);

    Optional<ShipDto> findShip(Long shipId);

    List<ShipDto> findShips();

    void deleteShip(Long shipId);
}
