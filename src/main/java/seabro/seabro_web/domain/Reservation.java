package seabro.seabro_web.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private boolean status;

    private int reserveSeat;

    private String reserveName;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}
