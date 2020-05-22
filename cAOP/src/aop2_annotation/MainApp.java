package aop2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		//MessageBean 구현한 클래스의 모든 메소드를 호출
		ApplicationContext context = new ClassPathXmlApplicationContext("aop2_annotation/applicationContext.xml");
		
		MessageBean bean = context.getBean("targetBean", MessageBean.class);
		
		bean.sayHello();
		System.out.println("--------------------");
		bean.engSayHello();
		System.out.println("--------------------");
		bean.test();
	}
}
