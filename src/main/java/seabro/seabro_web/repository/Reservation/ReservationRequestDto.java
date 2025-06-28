package seabro.seabro_web.repository.Reservation;

import lombok.Getter;

@Getter
public class ReservationRequestDto {
    private Long scheduleId;
    private String reserveName;
    private int reserveSeat;
}
