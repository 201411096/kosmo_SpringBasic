package ex04_xml_list;

import java.util.List;

public class ListBean {
	private List<Integer> intlist;
	private List<MemberBean> memberList;
	public List<Integer> getIntlist() {
		return intlist;
	}
	public void setIntlist(List<Integer> intlist) {
		this.intlist = intlist;
	}
	public List<MemberBean> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<MemberBean> memberList) {
		this.memberList = memberList;
	}
}
