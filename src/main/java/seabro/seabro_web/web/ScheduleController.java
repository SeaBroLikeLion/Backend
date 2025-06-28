package seabro.seabro_web.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seabro.seabro_web.domain.Schedule;
import seabro.seabro_web.dto.ScheduleQueryRequestDto;
import seabro.seabro_web.dto.ScheduleQueryResponseDto;
import seabro.seabro_web.repository.ScheduleRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;

    @PostMapping("/search")
    public ResponseEntity<List<ScheduleQueryResponseDto>> searchSchedules(@RequestBody ScheduleQueryRequestDto requestDto) {
        // String → LocalDate 변환
        LocalDate date = LocalDate.parse(requestDto.getDate());
        Long shipId = requestDto.getShipId();

        List<Schedule> schedules = scheduleRepository.findByShip_ShipIdAndDate(shipId, date);

        List<ScheduleQueryResponseDto> responseDtos = schedules.stream()
                .map(s -> new ScheduleQueryResponseDto(
                        s.getScheduleId(),
                        s.getDate().toString(),
                        s.getPort(),
                        s.getScale(),
                        s.getTotalSeat(),
                        s.getRemainSeat(),
                        s.getNotice(),
                        s.getPrice()
                ))
                .toList();

        return ResponseEntity.ok(responseDtos);
    }
}
