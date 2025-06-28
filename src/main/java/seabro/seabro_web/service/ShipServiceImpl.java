package seabro.seabro_web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import seabro.seabro_web.domain.Ship;
import seabro.seabro_web.repository.schedule.ScheduleDto;
import seabro.seabro_web.repository.schedule.ScheduleSearchCond;
import seabro.seabro_web.repository.ship.ShipDto;
import seabro.seabro_web.repository.ship.ShipRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipServiceImpl implements ShipService {

    private final ShipRepository shipRepository;

    @Override
    public ShipDto saveShip(ShipDto shipDto) {

        Ship ship = new Ship(shipDto);
        shipRepository.save(ship);
        return shipDto;
    }

    @Override
    public ShipDto updateShip(Long shipId, ShipDto updateParam) {
        Ship ship = shipRepository.findById(shipId).orElseThrow(NoSuchElementException::new);
        copyDtoToShip(updateParam, ship);
        new ShipDto(shipRepository.save(ship));
        return new ShipDto();
    }

    private static void copyDtoToShip(ShipDto updateParam, Ship ship) {
        ship.setShipName(updateParam.getShipName());
        ship.setContent(updateParam.getContent());
        ship.setTotalSeat(updateParam.getTotalSeat());
    }

    @Override
    public Optional<ShipDto> findShip(Long shipId) {

        return shipRepository.findById(shipId)
                .map(ShipDto::new);
    }

    @Override
    public List<ShipDto> findShips() {

        List<Ship> ships = shipRepository.findAll();
        List<ShipDto> shipDtos = ships.stream()
                .map(ShipDto::from)
                .toList();

        return shipDtos;
    }

    @Override
    public void deleteShip(Long shipId) {
        shipRepository.deleteById(shipId);
        return;
    }
}