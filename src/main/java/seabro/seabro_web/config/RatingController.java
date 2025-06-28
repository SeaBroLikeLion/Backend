package seabro.seabro_web.config;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seabro.seabro_web.dto.*;
import seabro.seabro_web.service.RatingService;

@RestController
@RequestMapping("/ships/{shipId}/reviews")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> addRating(
            @PathVariable Long shipId,
            @Valid @RequestBody RatingRequest request) {

        RatingResponse responseData = ratingService.createRating(shipId, request);

        ApiResponse apiResponse = new ApiResponse(true, 200, "후기 등록 성공", responseData);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse> removeRating(
            @PathVariable Long shipId,
            @PathVariable Long reviewId,
            @Valid @RequestBody DeleteRatingRequest request) {

        ratingService.deleteRating(shipId, reviewId, request);

        ApiResponse apiResponse = new ApiResponse(true, 200, "후기가 성공적으로 삭제되었습니다.", null);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ApiResponse> updateRating(@PathVariable Long shipId,
                                                    @PathVariable Long reviewId,
                                                    @Valid @RequestBody UpdateRatingRequest request) {

        RatingResponse responseData = ratingService.updateRating(shipId, reviewId, request);

        ApiResponse apiResponse = new ApiResponse(true, 200, "후기가 성공적으로 수정되었습니다.", responseData);
        return ResponseEntity.ok(apiResponse);
    }

}

