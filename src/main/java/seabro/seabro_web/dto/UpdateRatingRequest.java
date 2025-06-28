package seabro.seabro_web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRatingRequest {
    private String content;

    private Integer rate;
}