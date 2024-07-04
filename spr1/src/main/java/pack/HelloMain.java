package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// 처리 1 : 전통적 방법
		Message1 m1 = new Message1();
		m1.sayHello("래시포드");
		
		Message2 m2 = new Message2();
		m2.sayHello("호날두");
		
		System.out.println();
		MessageInter inter;
		inter = m1;
		inter.sayHello("브페");
		inter = m2;
		inter.sayHello("달로");
		
		// 처리 2 : Spring 방법
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		MessageInter inter2 = (MessageInter)context.getBean("mes1");
		inter2.sayHello("가르나초");
		MessageInter inter3 = (MessageInter)context.getBean("mes2");
		inter3.sayHello("마이누");
	}

}
