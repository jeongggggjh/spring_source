package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JikwonRepository extends JpaRepository<Jikwon, Integer> {
    List<Jikwon> findByJikwonJik(String jikwonJik);

    @Query("SELECT j FROM Jikwon j WHERE j.jikwonJik LIKE %:jik%")
    List<Jikwon> searchByJik(@Param("jik") String jik);
}
