package com.kh.mybatis.model.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.mybatis.model.dao.MybatisDAO;
import com.kh.mybatis.model.dao.MybatisDAOImpl;


public class MybatisServiceImpl implements MybatisService {
	
	private MybatisDAO mybatisDAO = new MybatisDAOImpl();

	private SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(is);
			// auto-commit 여부를 매개인자로 전달.
			session = factory.openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}

	@Override
	public int insertStudent() {
		SqlSession session = getSqlSession();
		
		int result = mybatisDAO.insertStudent(session);
		
		if( result > 0 )
			session.commit();
		else
			session.rollback();
		session.close();
		
		return result;		
	}

}
