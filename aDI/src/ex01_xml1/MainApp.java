package ex01_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("ex01_xml1/applicationContext.xml");
//		ClassPathXmlApplicationContext() -> spring bean파일을 가져옴
		System.out.println("start--------------------");
		MessageBean bean = context.getBean("en", MessageBean.class);
		bean.sayHello("홍길동");
		
		MessageBean bean2 = context.getBean("ko", MessageBean.class);
		bean2.sayHello("John");
		
		MessageBean bean1 = context.getBean("ko", MessageBean.class);
		bean1.sayHello("홍길숙");
		
		MessageBean bean3 = context.getBean("en", MessageBean.class);
		bean3.sayHello("Mike");
	}
}
