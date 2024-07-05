package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");
		
		Gogek rashford = (Gogek)context.getBean("gogek");
		rashford.selectBank("sinhan");
		rashford.playInputMoney(500);
		rashford.playOutputMoney(200);
		System.out.println("rashford - ");
		rashford.showMoney();

		Gogek bruno = (Gogek)context.getBean("gogek");
		bruno.selectBank("sinhan");
		bruno.playInputMoney(500);
		bruno.playOutputMoney(200);
		System.out.println("bruno - ");
		bruno.showMoney();
		
		Gogek mainoo = (Gogek)context.getBean("gogek");
		mainoo.selectBank("hana");
		mainoo.playInputMoney(500);
		mainoo.playOutputMoney(100);
		System.out.println("mainoo - ");
		mainoo.showMoney();
		
		System.out.println("객체 주소 rashford : " + rashford);
		System.out.println("객체 주소 bruno : " + bruno);
		System.out.println("객체 주소 mainoo : " + mainoo);
	}
}
