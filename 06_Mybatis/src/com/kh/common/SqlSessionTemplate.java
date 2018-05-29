package com.kh.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		
		String resource = "/mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			//auto-commit 여부를 인자로 전달.
			session = factory.openSession(false);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return session;
	}

}
