package seabro.seabro_web.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA를 위한 기본 생성자입니다.
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int rate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public Rating(Ship ship, String content, int rate) {
        this.ship = ship;
        this.content = content;
        this.rate = rate;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String newContent, int newRate) {
        this.content = newContent;
        this.rate = newRate;
    }
}
