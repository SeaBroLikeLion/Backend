package seabro.seabro_web.repository.schedule;

import lombok.Data;

@Data
public class ScheduleSearchCond {

    private String port;
    private String fishType;

    public ScheduleSearchCond() {
    }

    public ScheduleSearchCond(String port, String fishType) {
        this.port = port;
        this.fishType = fishType;
    }
}
