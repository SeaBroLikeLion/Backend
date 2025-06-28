package seabro.seabro_web.repository.ship;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import seabro.seabro_web.domain.Ship;

@Data
public class ShipDto {

    private String shipName;
    private String content;
    private Integer totalSeat;

    public ShipDto(Ship ship) {
        this.shipName = ship.getShipName();
        this.content = ship.getContent();
        this.totalSeat = ship.getTotalSeat();
    }

    public ShipDto() {
    }

    public ShipDto(String shipName, String content, Integer totalSeat) {
        this.shipName = shipName;
        this.content = content;
        this.totalSeat = totalSeat;
    }

    public static ShipDto from(Ship ship) {
        ShipDto dto = new ShipDto();
        dto.shipName = ship.getShipName();
        dto.content = ship.getContent();
        dto.totalSeat = ship.getTotalSeat();
        return dto;
    }
}



