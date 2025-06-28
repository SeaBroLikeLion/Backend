package seabro.seabro_web.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    private LocalDateTime date;
    private Integer scale;
    private String port;
    private Integer totalSeat;
    private Integer remainSeat;
    private String notice;
    private String fishType;
    private Integer price;

    public Schedule() {
    }
}
