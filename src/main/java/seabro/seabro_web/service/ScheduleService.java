package seabro.seabro_web.service;

import org.springframework.http.ResponseEntity;
import seabro.seabro_web.domain.Schedule;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.schedule.ScheduleSearchCond;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    Schedule saveSchedule(ScheduleDto schedule);

    void updateSchedule(Long scheduleId, ScheduleDto updateParam);

    Optional<ScheduleDto> findSchedule(Long scheduleId);

    List<ScheduleDto> findSchedules(ScheduleSearchCond scheduleSearchCond);

    void deleteSchedule(Long scheduleId);
}
