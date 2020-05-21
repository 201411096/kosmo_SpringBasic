package ex01_xml1;

public class MessageBeanKoImpl implements MessageBean{
	public MessageBeanKoImpl() {
		super();
		System.out.println("MessageBeanKoImpl 객체 생성");
	}

	@Override
	public void sayHello(String name) {
		System.out.println(name+"님 반갑습니다.");
	}
}
