package seabro.seabro_web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seabro.seabro_web.domain.Board;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class BoardResponse {
    private String ship_name;
    private String board_photo;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public static BoardResponse of(Board board){
        return new BoardResponse(
                board.getShip().getShipName(),
                board.getBoardPhoto(),
                board.getTitle(),
                board.getContent(),
                board.getCreatedAt()
        );
    }
}
