package seabro.seabro_web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seabro.seabro_web.domain.Reservation;
import seabro.seabro_web.domain.Schedule;
import seabro.seabro_web.dto.*;
import seabro.seabro_web.repository.Reservation.ReservationRequestDto;
import seabro.seabro_web.repository.Reservation.ReservationResponseDto;
import seabro.seabro_web.repository.ReservationRepository;
import seabro.seabro_web.repository.ScheduleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ScheduleRepository scheduleRepository;
    private final ReservationRepository reservationRepository;

    public List<ScheduleQueryResponseDto> getAvailableSchedules(Long shipId, String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        List<Schedule> schedules = scheduleRepository.findByShip_ShipIdAndDate(shipId, date);

        return schedules.stream().map(s ->
                new ScheduleQueryResponseDto(
                        s.getScheduleId(),
                        s.getDate().toString(),
                        s.getPort(),
                        s.getScale(),
                        s.getTotalSeat(),
                        s.getRemainSeat(),
                        s.getNotice(),
                        s.getPrice()
                )
        ).collect(Collectors.toList());
    }

    public ReservationResponseDto reserve(ReservationRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(dto.getScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("스케줄을 찾을 수 없습니다."));

        if (schedule.getRemainSeat() < dto.getReserveSeat()) {
            throw new IllegalArgumentException("잔여 좌석 부족");
        }

        schedule.setRemainSeat(schedule.getRemainSeat() - dto.getReserveSeat());
        scheduleRepository.save(schedule);

        Reservation reservation = new Reservation();
        reservation.setSchedule(schedule);
        reservation.setReserveName(dto.getReserveName());
        reservation.setReserveSeat(dto.getReserveSeat());
        reservation.setStatus(true);
        reservationRepository.save(reservation);

        return new ReservationResponseDto(200,
                schedule.getScheduleId(),
                reservation.getReserveName(),
                reservation.getReserveSeat(),
                schedule.getRemainSeat());
    }
}
