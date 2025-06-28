package seabro.seabro_web.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import seabro.seabro_web.domain.Board;

import java.time.LocalDateTime;

@Getter
public class BoardAllResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long board_id;

    private final String title;
    private final String board_photo;
    private final String ship_name;
    private final LocalDateTime created_At;

    private BoardAllResponse(Board board) {
        this.board_id = board.getId();
        this.title = board.getTitle();
        this.board_photo = board.getBoardPhoto();
        this.ship_name = board.getShip().getShipName();
        this.created_At = board.getCreatedAt();
    }


    public static BoardAllResponse from(Board board) {
        return new BoardAllResponse(board);
    }
}
