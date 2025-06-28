package seabro.seabro_web.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import seabro.seabro_web.repository.ship.ShipDto;

@Data
@Entity
public class Ship {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipId;

    private String shipName;
    private String content;
    private Integer totalSeat;


    public Ship(ShipDto shipDto) {
        this.shipName = shipDto.getShipName();
        this.content = shipDto.getContent();
        this.totalSeat = shipDto.getTotalSeat();
    }

    public Ship() {

    }
}
