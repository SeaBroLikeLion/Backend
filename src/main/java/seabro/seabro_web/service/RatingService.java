package seabro.seabro_web.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seabro.seabro_web.domain.Rating;
import seabro.seabro_web.domain.Ship;
import seabro.seabro_web.dto.*;
import seabro.seabro_web.repository.RatingRepository;
import seabro.seabro_web.repository.ShipRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final ShipRepository shipRepository;

    @Transactional
    public RatingResponse createRating(Long shipId, RatingRequest request) {
        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new EntityNotFoundException("해당 ID의 선박을 찾을 수 없습니다."));

        Rating newRating = request.toEntity(ship);

        Rating savedRating = ratingRepository.save(newRating);

        return RatingResponse.of(savedRating);
    }
    @Transactional
    public void deleteRating(Long shipId, Long ratingId, DeleteRatingRequest request) {
        Rating rating = ratingRepository.findByIdAndShipId(ratingId, shipId)
                .orElseThrow(() -> new EntityNotFoundException("요청하신 후기를 찾을 수 없습니다."));

        ratingRepository.delete(rating);
    }

    @Transactional
    public RatingResponse updateRating(Long shipId, Long ratingId, UpdateRatingRequest request) {
        Rating rating = ratingRepository.findByIdAndShipId(ratingId, shipId)
                .orElseThrow(() -> new EntityNotFoundException("요청하신 후기를 찾을 수 없습니다."));

        rating.update(request.getContent(), request.getRate());

        return RatingResponse.of(rating);
    }


    public List<RatingAllResponse> findAllRatingsByShip(Long shipId) {
        List<Rating> ratingList = ratingRepository.findByShipIdOrderByIdDesc(shipId);
        return ratingList.stream()
                .map(RatingAllResponse::from) // 각 Rating을 RatingListResponse로 변환
                .toList();
    }

}
