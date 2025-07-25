package seabro.seabro_web.repository.Reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReservationResponseDto {
    private int code;
    private Long scheduleId;
    private String reserveName;
    private int reserveSeat;
    private int remainSeat;
}
