package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void abcd() {
        setDataSource(dataSource);
    }

    @Override
    public List<JikwonDto> selectList(String gogekNo, String gogekName) throws DataAccessException {
        RowMapper<JikwonDto> rowMapper = new JikwonMapper();
        String sql = "SELECT gogek_no, gogek_name, jikwon_name, jikwon_jik, jikwon_gen "
                   + "FROM gogek INNER JOIN jikwon ON gogek.gogek_damsano = jikwon.jikwon_no";
        
        if (gogekNo != null && !gogekNo.isEmpty() && gogekName != null && !gogekName.isEmpty()) {
            sql += " WHERE gogek.gogek_no = " + gogekNo + " AND gogek.gogek_name = " + "'" + gogekName + "'";
        }
        return getJdbcTemplate().query(sql, rowMapper);
		
    }

    class JikwonMapper implements RowMapper<JikwonDto> {
        @Override
        public JikwonDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            JikwonDto dto = new JikwonDto();
            dto.setGogek_no(rs.getString("gogek_no"));
            dto.setGogek_name(rs.getString("gogek_name"));
            dto.setJikwon_name(rs.getString("jikwon_name"));
            dto.setJikwon_jik(rs.getString("jikwon_jik"));
            dto.setJikwon_gen(rs.getString("jikwon_gen"));
            return dto;
        }
    }
}
