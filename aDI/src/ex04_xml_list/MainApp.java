package ex04_xml_list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		//1. spring 설정 파일 연결
		ApplicationContext context = new ClassPathXmlApplicationContext("ex04_xml_list/applicationContext.xml");
		
		//2. 빈 얻어오기
		ListBean bean = context.getBean("bean", ListBean.class);
//		ListBean bean = (ListBean)context.getBean("bean");
		
		for(Integer i : bean.getIntlist()) {
			System.out.println(i);
		}
		for(MemberBean m : bean.getMemberList()) {
			System.out.println(m.getName()+" : "+m.getMessage());
		}
		
	}
}
