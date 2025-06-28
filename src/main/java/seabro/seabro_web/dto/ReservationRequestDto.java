package seabro.seabro_web.dto;

import lombok.Getter;

@Getter
public class ReservationRequestDto {
    private Long scheduleId;
    private String reserveName;
    private int reserveSeat;
}
