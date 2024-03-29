package session;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//JDBC : Connection <-> Mybatis : SqlSession
public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory = null;
	static {
		try {
			if (sessionFactory == null) {
				Reader reader = Resources.getResourceAsReader("session/mybatis-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession();
	}
}
