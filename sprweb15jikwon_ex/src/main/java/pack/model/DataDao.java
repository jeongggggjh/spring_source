package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
    @Autowired
    private JikwonRepository repository;
    
    // 검색 자료 읽기
    public List<Jikwon> getDataSearch(String jik) {
        return repository.searchByJik(jik);
    }
}
