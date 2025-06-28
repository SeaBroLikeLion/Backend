package seabro.seabro_web.config;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seabro.seabro_web.dto.AddBoardRequest;
import seabro.seabro_web.dto.ApiResponse;
import seabro.seabro_web.dto.BoardAllResponse;
import seabro.seabro_web.dto.BoardResponse;
import seabro.seabro_web.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/ships/{shipId}/boards") // RESTful하게 복수형 'boards'로 변경
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping()
    public ResponseEntity<ApiResponse> addBoard(
            @PathVariable Long shipId,
            @RequestBody AddBoardRequest request) {
        BoardResponse responseData = boardService.addBoard(shipId, request);

        ApiResponse apiResponse = new ApiResponse(true, 200, "게시글 등록 성공", responseData);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }


    @GetMapping("/{boardId}")
    public ResponseEntity<ApiResponse> getBoardDetails(
            @PathVariable Long shipId,
            @PathVariable Long boardId) {

        BoardResponse responseData = boardService.getBoard(shipId, boardId);

        ApiResponse apiResponse = new ApiResponse(true, 200, "게시글 상세 조회 성공", responseData);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getBoardList(@PathVariable Long shipId) {
        List<BoardAllResponse> responseData = boardService.findAllByShip(shipId);

        ApiResponse apiResponse = new ApiResponse(true, 200, "게시글 목록 조회 성공", responseData);
        return ResponseEntity.ok(apiResponse);
    }

}
