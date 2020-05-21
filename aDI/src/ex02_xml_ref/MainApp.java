package ex02_xml_ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		// 1. 스프링 설정 파일 연결
		ApplicationContext context = new ClassPathXmlApplicationContext("ex02_xml_ref/applicationContext.xml");
		// 2. 빈 얻어오기
		MemberBean bean = context.getBean("member", MemberBean.class); // context.getBean(xml의 id와 같은 값, 클래스.. );
		System.out.println(bean.getName() + " / " + bean.getAge() + " / " + bean.getMessage());
		
		MemberBean bean2 = context.getBean("member2", MemberBean.class);
		System.out.println(bean2.getName() + " / " + bean2.getAge() + " / " + bean2.getMessage());
	}
}
