package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model 클래스를 호출

	@Autowired
	private JikwonInter inter;

	@Override
	public void dataJikwon() {
		List<JikwonDto> list = inter.selectDataAll();

		System.out.println("직원 자료\n사번 이름 부서명 입사년");
		// console로 출력
		for (JikwonDto j : list) {
			System.out.println(
					j.getJikwon_no() + " " + j.getJikwon_name() + " " + j.getBuser_name() + " " + j.getJikwon_ibsail());
		}
	}

	@Override
	public void dataCount() {
		List<JikwonDto> list = inter.selectCountAll();

		System.out.println("\n부서별 인원수");
		// console로 출력 
		for (JikwonDto j : list) {
			System.out.println(j.getBuser_name() + " : " + j.getJikwon_no());
		}
	}

	@Override
	public void dataPay() {
		List<JikwonDto> list = inter.selectPayAll();

		System.out.println("\n부서별 최대 급여자");
		for (JikwonDto j : list) {
			System.out.println(j.getBuser_name() + " : " + j.getJikwon_name() + " (" + j.getJikwon_pay() + ")");
		}

	}

}
