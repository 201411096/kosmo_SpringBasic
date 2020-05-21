package ex01_xml1;

public class MessageBeanEnImpl implements MessageBean{
	public MessageBeanEnImpl() {
		super();
		System.out.println("MessageBeanEnImpl 객체 생성");
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println(name + ", good morning");
	}
}
