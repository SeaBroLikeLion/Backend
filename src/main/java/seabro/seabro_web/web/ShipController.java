package seabro.seabro_web.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seabro.seabro_web.domain.Ship;
import seabro.seabro_web.repository.ShipRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ships")
public class ShipController {

    private final ShipRepository shipRepository;

    @PostMapping
    public ResponseEntity<Ship> createShip(@RequestBody Ship ship) {
        Ship saved = shipRepository.save(ship);
        return ResponseEntity.ok(saved);
    }
    @GetMapping
    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }
}
