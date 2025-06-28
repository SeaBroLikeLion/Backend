package seabro.seabro_web.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.schedule.ScheduleSearchCond;
import seabro.seabro_web.repository.ship.ShipDto;
import seabro.seabro_web.service.ScheduleService;
import seabro.seabro_web.service.ShipService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<ScheduleDto>> viewSchedules(ScheduleSearchCond cond) {
        List<ScheduleDto> schedules = scheduleService.findSchedules(cond);

        return ResponseEntity.ok(schedules);
    }

    @PostMapping
    public ResponseEntity<ShipDto> addShip(ShipDto shipDto) {
        return ResponseEntity.ok().body(shipService.saveShip(shipDto));
    }

    @PutMapping("/{shipId}")
    public ResponseEntity<ShipDto> updateShip(ShipDto updateParam, @PathVariable Long shipId) {
        return ResponseEntity.ok().body(shipService.updateShip(shipId, updateParam));
    }

    @DeleteMapping("/{shipId}")
    public ResponseEntity<Void> deleteShip(@PathVariable Long shipId) {
        shipService.deleteShip(shipId);
        return ResponseEntity.noContent().build();
    }
}
