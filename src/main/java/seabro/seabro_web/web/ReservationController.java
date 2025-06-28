package seabro.seabro_web.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seabro.seabro_web.domain.Reservation;
import seabro.seabro_web.repository.Reservation.ReservationRepository;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.service.ReservationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ships")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{shipId}/reservations")
    public ResponseEntity<List<ScheduleDto>> getReservations(
            @PathVariable Long shipId,
            @RequestParam String date) {

        List<ScheduleDto> schedules = reservationService.getAvailableSchedules(shipId, date);
        return ResponseEntity.ok(schedules);
    }
}
