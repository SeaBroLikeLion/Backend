package seabro.seabro_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seabro.seabro_web.domain.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    Optional<Rating> findByIdAndShipId(Long ratingId, Long shipId);
    List<Rating> findByShipIdOrderByIdDesc(Long shipId);
}
