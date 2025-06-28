package seabro.seabro_web.repository.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import seabro.seabro_web.domain.Schedule;
import seabro.seabro_web.domain.Ship;
import seabro.seabro_web.repository.ship.ShipDto;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class ScheduleDto {

    private String shipName;
    private LocalDateTime date;
    private Integer scale;
    private String port;
    private Integer totalSeat;
    private Integer remainSeat;
    private String notice;
    private String fishType;

    public ScheduleDto() {
    }

    public ScheduleDto(Schedule schedule) {
        this.shipName = schedule.getShip().getShipName();
        this.date = schedule.getDate();
        this.scale = schedule.getScale();
        this.port = schedule.getPort();
        this.totalSeat = schedule.getTotalSeat();
        this.remainSeat = schedule.getRemainSeat();
        this.notice = schedule.getNotice();
        this.fishType = schedule.getFishType();
    }
}
