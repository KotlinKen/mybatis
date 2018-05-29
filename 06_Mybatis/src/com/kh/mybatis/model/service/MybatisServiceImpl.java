package com.kh.mybatis.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.mybatis.model.dao.MybatisDAO;
import com.kh.mybatis.model.dao.MybatisDAOImpl;
import com.kh.mybatis.model.vo.Student;


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

	@Override
	public int insertStudent(String name) {
		SqlSession session = getSqlSession();
		
		int result = mybatisDAO.insertStudent(session, name);
		
		
		if( result > 0 )
			session.commit();
		else
			session.rollback();
		session.close();
		
		return result;	
	}

	@Override
	public int insertStudent(Student student) {
		SqlSession session = getSqlSession();
		
		int result = mybatisDAO.insertStudent(session, student);
		
		
		if( result > 0 )
			session.commit();
		else
			session.rollback();
		session.close();
		
		return result;	
	}

	@Override
	public int insertStudent(Map<String, String> map) {
		SqlSession session = getSqlSession();
		
		int result = mybatisDAO.insertStudent(session, map);
		
		
		if( result > 0 )
			session.commit();
		else
			session.rollback();
		session.close();
		
		return result;	
	}

	@Override
	public int insertStudent(HashMap<String, Student> map) {
		SqlSession session = getSqlSession();
		
		int result = mybatisDAO.insertStudent(session, map);
		
		
		if( result > 0 )
			session.commit();
		else
			session.rollback();
		session.close();
		
		return result;	
	}

	@Override
	public int selectStudentCount() {
		SqlSession session = getSqlSession();
		
		int count = mybatisDAO.selectStudentCount(session);
		session.close();
		
		return count;	
	}

	@Override
	public String selectStudentName(int studentNo) {
		SqlSession session = getSqlSession();
		
		String studentName = mybatisDAO.selectStudentName(session, studentNo);
		session.close();
		
		return studentName;	
	}

	@Override
	public int deleteOne(int studentNo) {
		SqlSession session = getSqlSession();
		System.out.println(studentNo);
		int result = mybatisDAO.deleteOne(session, studentNo);
		
		
		
		if( result > 0 )
			session.commit();
		else
			session.rollback();
		session.close();
		
		return result;
	}

	@Override
	public Student selectStudentOne(int studentNo) {
		SqlSession session = getSqlSession();
		
		Student s = mybatisDAO.selectStudentOne(session, studentNo);
		session.close();
		
		return s;	
	}

	@Override
	public List<Student> selectList() {
		SqlSession session = getSqlSession();
		
		List<Student> list = mybatisDAO.selectList(session);
		session.close();
		
		return list;
	}

}
