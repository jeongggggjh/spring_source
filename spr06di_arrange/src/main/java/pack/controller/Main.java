package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml");
		*/
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:arrange.xml");
		
		System.out.println("Singleton 확인");
		MessageImpl impl1 = (MessageImpl)context.getBean("mImpl");
		impl1.sayHi();
		MessageImpl impl2 = (MessageImpl)context.getBean("mImpl");
		impl2.sayHi();
		
		System.out.println("객체 주소 : " + impl1 + " " + impl2);
		
		System.out.println("--- 다형성 처리");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		System.out.println();
		System.out.println("--- 다형성 처리 2");
		MessageInter inter2 = context.getBean("mImpl", MessageInter.class);
		inter2.sayHi();
		
		context.close();
	}

}
