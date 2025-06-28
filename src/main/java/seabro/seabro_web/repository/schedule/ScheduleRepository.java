package seabro.seabro_web.repository.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import seabro.seabro_web.domain.Schedule;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("""
select s from Schedule s
join fetch s.ship
where (:fishType is null or s.fishType = :fishType)
  and (:local is null or s.port = :port)
""")
    List<Schedule> search(
            @Param("fishType") String fishType,
            @Param("local")    String port);
}
