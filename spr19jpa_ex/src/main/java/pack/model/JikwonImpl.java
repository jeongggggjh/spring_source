package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl implements JikwonInter {

	@Override
	public List<JikwonDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<JikwonDto> list = null;

		try {
			tx.begin();
			list = em.createQuery("select j from JikwonDto as j",JikwonDto.class).getResultList();
			tx.commit();
		} catch (Exception e) {
				tx.rollback();
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}

		return list;
	}

	@Override
	public List<JikwonDto> selectCountAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		List<Object[]> list = null;

		try {
			tx.begin();
			list = em.createQuery("select j.buser_num, count(j) "
					+ "from JikwonDto j group by j.buser_num", Object[].class).getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}

		if (list != null) {
			return list.stream().map(result -> {
				JikwonDto dto = new JikwonDto();
				dto.setBuser_num((String) result[0]);
				dto.setJikwon_no(String.valueOf(result[1])); // 인원수를 jikwon_no 필드에 임시 저장
				return dto;
			}).collect(Collectors.toList());
		} else {
			return null;
		}
	}
}
