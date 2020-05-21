package ex06_autowiring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private String message;
	
//	@Autowired
//	@Qualifier("outputer2")
	@Resource(name="outputer2")
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
