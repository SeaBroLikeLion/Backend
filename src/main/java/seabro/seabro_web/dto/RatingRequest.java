package seabro.seabro_web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import seabro.seabro_web.domain.Rating;
import seabro.seabro_web.domain.Ship;

@Getter
@NoArgsConstructor
public class RatingRequest {

    private String password;

    private String content;

    private Integer rate;


    public Rating toEntity(Ship ship) {
        return Rating.builder()
                .ship(ship)
                .content(this.content)
                .rate(this.rate)
                .build();
    }
}
