package seabro.seabro_web.domain;

import jakarta.persistence.*;
        import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 이 클래스가 데이터베이스 테이블과 매핑되는 JPA 엔티티임을 선언합니다.
@Getter // 모든 필드에 대한 Getter 메소드를 자동으로 생성합니다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA를 위한 기본 생성자. 무분별한 생성을 막기 위해 protected로 설정합니다.
public class Ship {

    @Id // 이 필드가 테이블의 Primary Key(PK)임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 값을 데이터베이스의 IDENTITY 전략에 따라 자동 생성합니다.
    @Column(name = "ship_id")
    private Long id; // PK는 int보다 표현 범위가 넓은 Long 타입을 사용하는 것이 일반적입니다.

    @Column(name = "ship_name", nullable = false, length = 50) // 'ship_name' 칼럼, null 불가능, 길이 50자로 제한
    private String shipName;

    @Column(name = "fish_type")
    private String fishType; // 주요 어종

    @Column(name = "ship_photo")
    private String shipPhoto; // 선박 대표 사진의 URL을 저장

    @Lob // VARCHAR보다 훨씬 긴 텍스트를 저장할 수 있는 CLOB 타입으로 매핑
    private String content; // 선박 상세 소개

    @Column(name = "total_seats", nullable = false)
    private int totalSeats; // 총 좌석 수

    /**
     * 빌더 패턴을 사용하여 객체를 생성하는 생성자
     * 명확하고 안전하게 객체를 초기화할 수 있습니다.
     */
    @Builder
    public Ship(String shipName, String fishType, String shipPhoto, String content, int totalSeats) {
        this.shipName = shipName;
        this.fishType = fishType;
        this.shipPhoto = shipPhoto;
        this.content = content;
        this.totalSeats = totalSeats;
    }
}
