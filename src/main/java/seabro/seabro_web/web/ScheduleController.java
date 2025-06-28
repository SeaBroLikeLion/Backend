package seabro.seabro_web.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import seabro.seabro_web.domain.Schedule;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.ship.ShipDto;
import seabro.seabro_web.service.ScheduleService;
import seabro.seabro_web.service.ShipService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/ships/{shipId}/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ShipService shipService;

    @PostMapping
    public ResponseEntity<ScheduleDto> addSchedule(@PathVariable Long shipId, @RequestBody ScheduleDto scheduleDto) {
        Schedule schedule = scheduleService.saveSchedule(scheduleDto, shipId);
        return ResponseEntity.ok().body(new ScheduleDto(schedule));
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleDto> getSchedule(@PathVariable Long shipId, @PathVariable Long scheduleId) {
        Optional<ScheduleDto> schedule = scheduleService.findSchedule(scheduleId);
        return ResponseEntity.ok().body(schedule.get());
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleDto> updateSchedule(ScheduleDto updateParam, @PathVariable Long scheduleId) {
        return ResponseEntity.ok().body(scheduleService.updateSchedule(scheduleId, updateParam););
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteShip(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return ResponseEntity.noContent().build();
    }
}
