package seabro.seabro_web.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.schedule.ScheduleSearchCond;
import seabro.seabro_web.repository.ship.ShipDto;
import seabro.seabro_web.service.ScheduleService;
import seabro.seabro_web.service.ShipService;

import java.util.List;

@Slf4j
@RestController  // ✅ REST API 응답을 위해 변경
@RequiredArgsConstructor
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ScheduleService scheduleService;

    // ✅ 전체 또는 조건별 스케줄 조회
    @GetMapping
    public ResponseEntity<List<ScheduleDto>> viewSchedules(ScheduleSearchCond cond) {
        List<ScheduleDto> schedules = scheduleService.findSchedules(cond);
        return ResponseEntity.ok(schedules);
    }

    // ✅ 선박 등록
    @PostMapping
    public ResponseEntity<ShipDto> addShip(@RequestBody ShipDto shipDto) {
        ShipDto saved = shipService.saveShip(shipDto);
        return ResponseEntity.ok(saved);
    }

    // ✅ 선박 수정
    @PutMapping("/{shipId}")
    public ResponseEntity<Void> updateShip(@RequestBody ShipDto updateParam, @PathVariable Long shipId) {
        shipService.updateShip(shipId, updateParam);  // 서비스에서 수정 로직 수행
        return ResponseEntity.noContent().build();
    }

    // ✅ 선박 삭제
    @DeleteMapping("/{shipId}")
    public ResponseEntity<Void> deleteShip(@PathVariable Long shipId) {
        shipService.deleteShip(shipId);
        return ResponseEntity.noContent().build();
    }
}
