package seabro.seabro_web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleQueryResponseDto {
    private Long scheduleId;
    private String date;
    private String port;
    private int scale;
    private int totalSeat;
    private int remainSeat;
    private String notice;
    private int price;
}
