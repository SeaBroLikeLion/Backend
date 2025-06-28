package seabro.seabro_web.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seabro.seabro_web.dto.AddBoardRequest;
import seabro.seabro_web.dto.ApiResponse;
import seabro.seabro_web.dto.BoardAllResponse;
import seabro.seabro_web.dto.BoardResponse;
import seabro.seabro_web.service.BoardService;
import seabro.seabro_web.service.InformService;

import java.util.List;

@RestController
@RequestMapping("/ships/{shipId}/inform") // RESTful하게 복수형 'boards'로 변경
public class InformController {

    private final InformService informService;

    public InformController(InformService informService) {
        this.informService = informService;
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<ApiResponse> getBoardDetails(
            @PathVariable Long shipId,
            @PathVariable Long boardId) {

        BoardResponse responseData = informService.getBoard(shipId, boardId);

        ApiResponse apiResponse = new ApiResponse(true, 200, "게시글 상세 조회 성공", responseData);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getBoardList(@PathVariable Long shipId) {
        List<BoardAllResponse> responseData = informService.findAllByShip(shipId);

        ApiResponse apiResponse = new ApiResponse(true, 200, "게시글 목록 조회 성공", responseData);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> addBoard(
            @PathVariable Long shipId,
            @RequestBody AddBoardRequest request) {
        BoardResponse responseData = informService.addBoard(shipId, request);

        ApiResponse apiResponse = new ApiResponse(true, 200, "게시글 등록 성공", responseData);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

}

