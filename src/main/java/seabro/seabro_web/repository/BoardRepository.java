package seabro.seabro_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seabro.seabro_web.domain.Board;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByIdAndShipId(Long boardId, Long shipId);

    List<Board> findByShipIdOrderByIdDesc(Long shipId);
}
