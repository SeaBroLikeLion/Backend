package seabro.seabro_web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import seabro.seabro_web.domain.Schedule;
import seabro.seabro_web.domain.Ship;
import seabro.seabro_web.repository.schedule.ScheduleRepository;
import seabro.seabro_web.repository.schedule.ScheduleSearchCond;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.ship.ShipDto;
import seabro.seabro_web.repository.ship.ShipRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ShipRepository shipRepository;

    @Override
    public Schedule saveSchedule(ScheduleDto scheduleDto, Long shipId) {
        Schedule schedule = new Schedule();

        copyDtoToSchedule(scheduleDto, schedule);
        Optional<Ship> ship = shipRepository.findById(shipId);
        schedule.setShip(ship.get());
        return scheduleRepository.save(schedule);
    }

    @Override
    public void updateSchedule(Long scheduleId, ScheduleDto updateParam) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(NoSuchElementException::new);
        copyDtoToSchedule(updateParam, schedule);
        scheduleRepository.save(schedule);
    }

    private static void copyDtoToSchedule(ScheduleDto updateParam, Schedule schedule) {
        schedule.setDate(updateParam.getDate());
        schedule.setScale(updateParam.getScale());
        schedule.setPort(updateParam.getPort());
        schedule.setTotalSeat(updateParam.getTotalSeat());
        schedule.setRemainSeat(updateParam.getRemainSeat());
        schedule.setNotice(updateParam.getNotice());
        schedule.setFishType(updateParam.getFishType());
    }

    @Override
    public Optional<ScheduleDto> findSchedule(Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(NoSuchElementException::new);

        return Optional.of(new ScheduleDto(schedule));
    }

    @Override
    public List<ScheduleDto> findSchedules(ScheduleSearchCond scheduleSearchCond) {

        List<Schedule> schedules = scheduleRepository.search(scheduleSearchCond.getFishType(), scheduleSearchCond.getPort());
        List<ScheduleDto> scheduleDtoList = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleDto scheduleDto = new ScheduleDto(schedule);
            scheduleDtoList.add(scheduleDto);
        }

        return scheduleDtoList;
    }

    @Override
    public void deleteSchedule(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }
}
