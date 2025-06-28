package seabro.seabro_web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import seabro.seabro_web.domain.Board;
import seabro.seabro_web.domain.Ship;

@Getter
@NoArgsConstructor
public class AddBoardRequest {

    private String title;
    private String content;
    private String boardPhoto;

    public Board toEntity(Ship ship) {
        return Board.builder()
                .ship(ship)
                .title(this.title)
                .content(this.content)
                .boardPhoto(this.boardPhoto)
                .build();
    }
}
