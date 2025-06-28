package seabro.seabro_web.dto;

import lombok.Getter;
import seabro.seabro_web.domain.Rating;

import java.time.LocalDateTime;

@Getter
public class RatingResponse {
    private final Long ratingId;
    private final Long shipId;
    private final String shipName;
    private final String content;
    private final int rate;
    private final LocalDateTime createdAt;

    private RatingResponse(Rating rating) {
        this.ratingId = rating.getId();
        this.shipId = rating.getShip().getId();
        this.shipName = rating.getShip().getShipName();
        this.content = rating.getContent();
        this.rate = rating.getRate();
        this.createdAt = rating.getCreatedAt();
    }

    public static RatingResponse of(Rating rating) {
        return new RatingResponse(rating);
    }
}
