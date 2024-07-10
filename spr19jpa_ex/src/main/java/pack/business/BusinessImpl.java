package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
    @Autowired
    private JikwonInter inter;

    @Override
    public void dataJikwon() {
        List<JikwonDto> list = inter.selectDataAll();

        System.out.println("직원 자료\n사번 이름 부서번호 입사년");
        for (JikwonDto j : list) {
            System.out.println(
                    j.getJikwon_no() + " " + j.getJikwon_name() + " " + j.getBuser_num() + " " + j.getJikwon_ibsail());
        }
    }

    @Override
    public void dataCount() {
        List<JikwonDto> list = inter.selectCountAll();

        System.out.println("부서별 인원수");
        for (JikwonDto result : list) {
            String buser_num = result.getBuser_num();
            String jikwon_no = result.getJikwon_no(); // 인원수를 jikwon_no 필드에 임시 저장
            System.out.println(buser_num + " : " + jikwon_no);
        }
    }
}
