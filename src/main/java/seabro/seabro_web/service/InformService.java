package seabro.seabro_web.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seabro.seabro_web.domain.Board;
import seabro.seabro_web.domain.Ship;
import seabro.seabro_web.dto.AddBoardRequest;
import seabro.seabro_web.dto.BoardAllResponse;
import seabro.seabro_web.dto.BoardResponse;
import seabro.seabro_web.repository.InformRepository;
import seabro.seabro_web.repository.ShipRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformService {

    private final InformRepository informRepository;
    private final ShipRepository shipRepository;

    public BoardResponse getBoard(Long shipId, Long boardId) {

        Board board = informRepository.findByIdAndShipId(boardId, shipId)
                .orElseThrow(() -> new EntityNotFoundException("ID에 해당하는 게시글을 찾을 수 없습니다."));


        return BoardResponse.of(board);
    }

    public List<BoardAllResponse> findAllByShip(Long shipId) {
        List<Board> boardList = informRepository.findByShipIdOrderByIdDesc(shipId);

        return boardList.stream()
                .map(BoardAllResponse::from)
                .toList();
    }

    public BoardResponse addBoard(Long shipId, AddBoardRequest request) {
        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 선박을 찾을 수 없습니다."));

        Board newBoard = request.toEntity(ship);

        Board savedBoard = informRepository.save(newBoard);

        return BoardResponse.of(savedBoard);
    }
}

