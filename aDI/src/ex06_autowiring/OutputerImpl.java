package ex06_autowiring;

import java.io.FileWriter;

public class OutputerImpl implements Outputer {
	String path;
	
	public void setPath(String path) {
		this.path=path;
	}
	
	@Override
	public void write(String msg) throws Exception {
		FileWriter f = new FileWriter(path);
		f.write(msg);
		f.close();
	}
}
