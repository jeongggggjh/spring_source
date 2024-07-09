package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<JikwonDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectDataAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	@Override
	public List<JikwonDto> selectCountAll() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectCountAll();
		} catch (Exception e) {
			System.out.println("selectCountAll err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	@Override
	public List<JikwonDto> selectPayAll() {
		SqlSession sqlSession = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectPayAll();
		} catch (Exception e) {
			System.out.println("selectPayAll err : " + e);
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
}
