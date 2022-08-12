package co.dev.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {
	
	public static SqlSessionFactory sessionFactory;
	
	static {
		String resource = "co/dev/mybatisdb/mybatis-config.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory () {
		return sessionFactory; //실제 세션을 가지고 있는 것
	}

}
