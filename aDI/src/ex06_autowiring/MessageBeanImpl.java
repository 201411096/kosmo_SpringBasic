package ex06_autowiring;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private String message;
	
	@Autowired
	private Outputer outputer;
	
	@Override
	public void sayHello() {
		System.out.println(name+"님께 " + message);
		try {
			outputer.write(name+"님께" + message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
