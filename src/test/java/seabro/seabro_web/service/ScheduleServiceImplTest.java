package seabro.seabro_web.service;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.schedule.ScheduleRepository;
import seabro.seabro_web.repository.ship.ShipRepository;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
class ScheduleServiceImplTest {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ShipService shipService;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ShipRepository shipRepository;

    @BeforeEach
    void init() {
    }

    @AfterEach
    void cleanup() {
        shipRepository.deleteAll();
        scheduleRepository.deleteAll();
    }

    @Test
    void saveScheduleTest() {
        ScheduleDto scheduleDto = new ScheduleDto(
            "테스트호",
                LocalDateTime.parse("2025-06-28T17:04:00"),
                11,
                "대천항",
                15,
                10,
                "구명조끼 지참 바랍니다.",
                "참돔"
        );

        scheduleService.saveSchedule(scheduleDto);
        log.info("scheduleDto = {}", scheduleDto);
        Assertions.assertThat(scheduleRepository.findById(1L)).isEqualTo(scheduleDto);

    }
}