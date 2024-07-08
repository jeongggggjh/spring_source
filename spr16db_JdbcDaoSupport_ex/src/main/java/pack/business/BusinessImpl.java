package pack.business;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model을 포함관계로 호출
	@Autowired
	private JikwonInter jikwonInter;
	
	@Override
	public void jikwonList() {
		System.out.print("고객 번호 : ");
		Scanner sc = new Scanner(System.in);
		String gogekNo = sc.next();
		System.out.print("고객 이름 : ");
		String gogekName = sc.next();
		sc.close();
		
		List<JikwonDto> list = jikwonInter.selectList(gogekNo, gogekName);
		if(list.isEmpty()) {
			System.out.println("그런 고객 없음 ㅋㅋ;");
		}
		
		for(JikwonDto j : list) {
			System.out.println("직원 이름 : " + j.getJikwon_name() + ", " + 
					"직원 직급 : " + j.getJikwon_jik() + ", " + 
					"직원 성별 : " + j.getJikwon_gen());
		}
	}
}
