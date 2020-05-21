package ex02_xml_ref;

public class MemberDAO {
	private MemberBean member;
	
	public MemberDAO() {}
	// (1) constructor 이용
	public MemberDAO(MemberBean member) {
		this.member=member;
	}
	// (2) setter getter 이용
	public MemberBean getMember() {
		return member;
	}
	public void setMember(MemberBean member) {
		this.member = member;
	}	
	public void insert() {
		System.out.println("DB에 " + member.getName() + "<" + member.getAge() + "> " + member.getMessage() + " 내용을 입렵합니다.");
	}
}
