package ex05_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		// 1. 스프링 설정 파일 연결
		ApplicationContext context = new ClassPathXmlApplicationContext("ex05_annotation/applicationContext.xml");
		// 2. 빈 얻어오기
		MemberDAO dao = context.getBean("memberDAO", MemberDAO.class);
		dao.insert();
	}
}
