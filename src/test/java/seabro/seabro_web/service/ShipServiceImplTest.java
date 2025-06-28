package seabro.seabro_web.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import seabro.seabro_web.domain.Ship;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.schedule.ScheduleRepository;
import seabro.seabro_web.repository.ship.ShipDto;
import seabro.seabro_web.repository.ship.ShipRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
class ShipServiceImplTest {

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
    void saveShipTest() {

        ShipDto shipDto = new ShipDto(
                "테스트호",
                "지리는 배입니다.",
                15
        );

        ShipDto saved = shipService.saveShip(shipDto);
        assertThat(saved).isEqualTo(shipDto);
    }

    @Test
    void findShipByIdTest() {

        ShipDto shipDto = new ShipDto(
                "테스트호",
                "지리는 배입니다.",
                15
        );

        ShipDto saved = shipService.saveShip(shipDto);
        Optional<ShipDto> ship = shipService.findShip(6L);
        assertThat(ship).isEqualTo(Optional.of(saved));
    }

    @Test
    void updateShip() {
        ShipDto shipDto = new ShipDto(
                "테스트호",
                "지리는 배입니다.",
                15
        );

        ShipDto saved = shipService.saveShip(shipDto);

        ShipDto updateParam = new ShipDto(
                "테스트 2호",
                "별로 지리진 않습니다",
                16
        );

        shipService.updateShip(2L, updateParam);

        Optional<ShipDto> updated = shipService.findShip(2L);

        assertThat(updated).isEqualTo(Optional.of(updateParam));
    }

    @Test
    void findShips() {
        ShipDto shipDto1 = new ShipDto(
                "테스트호",
                "지리는 배입니다.",
                15
        );

        ShipDto shipDto2 = new ShipDto(
                "테스트 2호",
                "지리는 배입니다.",
                151
        );

        ShipDto shipDto3 = new ShipDto(
                "테스트 3호",
                "지리는 배입니다.",
                153
        );

        ShipDto saved1 = shipService.saveShip(shipDto1);
        ShipDto saved2 = shipService.saveShip(shipDto2);
        ShipDto saved3 = shipService.saveShip(shipDto3);

        List<ShipDto> ships = shipService.findShips();

        assertThat(ships.get(0)).isEqualTo(saved1);
        assertThat(ships.get(1)).isEqualTo(saved2);
        assertThat(ships.get(2)).isEqualTo(saved3);
    }

    @Test
    void deleteShip() {
        ShipDto shipDto = new ShipDto(
                "테스트호",
                "지리는 배입니다.",
                15
        );

        ShipDto saved = shipService.saveShip(shipDto);
        shipService.deleteShip(1L);
        assertThat(shipService.findShip(1L)).isEqualTo(Optional.empty());
    }

}