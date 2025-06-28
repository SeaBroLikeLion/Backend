package seabro.seabro_web.dto;

import seabro.seabro_web.domain.Rating;

import java.time.LocalDateTime;

public class RatingAllResponse {
    private final Long rating_id;
    private final String content;
    private final String ship_name;
    private final LocalDateTime created_At;
    private final int rate;

    private RatingAllResponse(Rating rating) {
        this.rating_id = rating.getId();
        this.content = rating.getContent(); // 목록에서는 내용 일부만 보여주도록 로직 추가 가능
        this.ship_name = rating.getShip().getShipName();
        this.created_At = rating.getCreatedAt();
        this.rate = rating.getRate();
    }

    // Rating 엔티티를 목록 조회용 DTO로 변환하는 정적 팩토리 메소드
    public static RatingAllResponse from(Rating rating) {
        return new RatingAllResponse(rating);
    }
}