package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherClass;

@SpringBootApplication
@ComponentScan(basePackages = {"other"})
public class Sprweb13jpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb13jpaBasicApplication.class, args)
				.getBean(Sprweb13jpaBasicApplication.class).myExecute();
	}
	
	@Autowired
	ProductCrudRepository crudRepository;
	
	@Autowired
	OtherClass otherClass;
	
	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		
		delData();
		insData();
		selectData();
		
		otherClass.abc();
	}
	
	private void insData() {
		ProductVo productVo = new ProductVo(2, "사랑비", 10, 2000);
		// System.out.println(productVo.toString());
		crudRepository.save(productVo);
		
	}
	
	private void delData() {
		crudRepository.deleteById(5);
	}
	
	private void selectData() {
		// 전체 레코드 읽기
		List<ProductVo> list = (List<ProductVo>)crudRepository.findAll();
		// System.out.println(list.get(0).getSang());
		for(ProductVo p : list) {
			System.out.println(p.getCode() + " " + 
						p.getSang() + " " +
						p.getSu() + " " +
						p.getDan());
		}
		System.out.println();
		// 1개 레코드 읽기
		ProductVo vo = crudRepository.findById(2).get();
		System.out.println(vo.getCode() + " " + 
				vo.getSang() + " " +
				vo.getSu() + " " +
				vo.getDan());
	}

}
