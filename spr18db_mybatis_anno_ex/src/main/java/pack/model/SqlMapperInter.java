package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	// 직원 자료 출력 
	@Select("select jikwon_no, jikwon_name, year(jikwon_ibsail) as jikwon_ibsail, "
			+ "nvl(buser_name, '무소속') as buser_name "
			+ "from jikwon inner join buser on jikwon.buser_num = buser.buser_no")
	public List<JikwonDto> selectDataAll();
	
	// 부서별 인원수 출력
	@Select("select buser_name, count(jikwon_no) as jikwon_no from buser inner join jikwon on buser_no=buser_num group by buser_num")
	public List<JikwonDto> selectCountAll();
	
	// 부서별 최대 급여자 출력
	@Select("select buser_name, jikwon_name, jikwon_pay from buser inner join jikwon on buser_no="
			+ " buser_num where jikwon_pay in(select max(jikwon_pay) from jikwon j where j.buser_num=jikwon.buser_num)")
	public List<JikwonDto> selectPayAll();
	
}
