package com.kh.mybatis.model.dao;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;


public class MybatisDAOImpl implements MybatisDAO {

	@Override
	public int insertStudent(SqlSession session) {
		// mybatis : namespace, test1 : id
		int result = session.insert("mybatis.test1");
		
		System.out.println("result@DAO= " + result);
		
		return result;
	}

	@Override
	public int insertStudent(SqlSession session, String name) {
		int result = session.insert("mybatis.test2", name);
		
		System.out.println("result2@DAO= " + result);
		
		
		return result;
	}

	@Override
	public int insertStudent(SqlSession session, Student student) {
		int result = session.insert("mybatis.insertStudent1", student);
		
		System.out.println("result2@DAO= " + result);
		
		
		return result;
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, String> map) {
		int result = session.insert("mybatis.insertStudent2", map);
		
		System.out.println("result2@DAO= " + result);
		
		
		return result;
	}

}
