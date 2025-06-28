package seabro.seabro_web.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Board{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="board_id",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_id")
    private Ship ship;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(name = "board_photo",nullable=false)
    private String boardPhoto;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;


    public Board(Ship ship, String title, String content, String boardPhoto) {
        this.ship = ship;
        this.title = title;
        this.content = content;
        this.boardPhoto = boardPhoto;
        this.createdAt = LocalDateTime.now();
    }
}