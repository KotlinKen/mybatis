package com.kh.mybatis.model.service;

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

public class MybatisServiseImpl implements MybatisService {
	private MybatisDAO mybatisDAO = new MybatisDAOImpl();

	private SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "/mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(resource);
			System.out.println("1");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			System.out.println("2");
			SqlSessionFactory factory = builder.build(is);
			//auto-commit 여부를 매개인자로 전달.
			session = factory.openSession(false);
			System.out.println("3");
			
		} catch (Exception e) {
		}
		System.out.println("4");
		return session;
	}

	@Override
	public int insertStudent() {
		System.out.println("5");
		SqlSession session = getSqlSession();
		System.out.println("6");
		int result = mybatisDAO.insertStudent(session);
		System.out.println("7");
		if(result>0) {session.commit();}
		else {session.rollback();}
		System.out.println("8");
		return result;
	}

	@Override
	public int insertStudent(String name) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.insertStudent(name,session);
		if(result>0) {session.commit();}
		else {session.close();}
		
		return result;
	}

	@Override
	public int insertStudent(Student st) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.insertStudent(st,session);
		if(result>0) {session.commit();}
		else {session.close();}
		
		return result;
	}

	@Override
	public int insertStudent(Map<String, String> map) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.insertStudent(session,map);
		if(result>0) {session.commit();}
		else {session.close();}
		return result;
	}

	@Override
	public int insertStudent(HashMap<String, Student> map) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.insertStudent(session,map);
		if(result>0) {session.commit();}
		else {session.close();}
		return result;
	}

	@Override
	public int selectStudentcount() {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.selectStudentcount(session);
		
		return result;
	}

	@Override
	public String selectStudentName(int studentNo) {
		SqlSession session = getSqlSession();
		String studentName = mybatisDAO.selectStudentName(studentNo,session);
		session.close();
		return studentName;
	}

	@Override
	public int deletStudent(int studentNo) {
		SqlSession session = getSqlSession();
		int result = mybatisDAO.deletStudent(session,studentNo);
		if(result>0) {session.commit();}
		else {session.close();}
		return result;
	}

	@Override
	public Student searchStudent(int studentNo) {
		SqlSession session = getSqlSession();
		Student s = mybatisDAO.searchStudent(studentNo,session);
		return s;
	}

	@Override
	public List<Student> selectList() {
		SqlSession session = getSqlSession();
		List<Student> list = mybatisDAO.selectList(session);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, String>> selectMapList() {
		SqlSession session = getSqlSession();
		System.out.println("??");
		List<Map<String, String>> mapList = mybatisDAO.selectMapList(session);
		return mapList;
	}


}
