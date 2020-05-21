package ex05_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	@Autowired
	private MemberBean member;
	
//  생성자와 setter가 없는 상태
//	public MemberDAO() {}
//	// (1) constructor 이용
//	public MemberDAO(MemberBean member) {
//		this.member=member;
//	}
//	// (2) setter getter 이용
//	public MemberBean getMember() {
//		return member;
//	}
//	public void setMember(MemberBean member) {
//		this.member = member;
//	}
	
	public void insert() {
		System.out.println("DB에 " + member.getName() + "<" + member.getAge() + "> " + member.getMessage() + " 내용을 입렵합니다.");
	}
}
