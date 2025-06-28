package seabro.seabro_web.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long shipId;

    @Column(nullable = false)
    private String shipName;

    @Column(nullable = false)
    private String fishType;

    @Column(nullable = false)
    private String shipPhoto;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer seat;

    public Ship(String shipName, String fishType, String shipPhoto, String content, Integer seat) {
        this.shipName = shipName;
        this.fishType = fishType;
        this.shipPhoto = shipPhoto;
        this.content = content;
        this.seat = seat;
    }

    public void update(String shipName, String fishType, String shipPhoto, String content, Integer seat) {
        this.shipName = shipName;
        this.fishType = fishType;
        this.shipPhoto = shipPhoto;
        this.content = content;
        this.seat = seat;
    }
}
