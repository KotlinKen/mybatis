package com.kh.mybatis.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public interface MybatisDAO {
	
	int insertStudent(SqlSession session);

	int insertStudent(SqlSession session, String name);

	int insertStudent(SqlSession session, Student student);

	int insertStudent(SqlSession session, Map<String, String> map);

	int insertStudent(SqlSession session, HashMap<String, Student> map);

	int selectStudentCount(SqlSession session);

	String selectStudentName(SqlSession session, int studentNo);

	int deleteOne(SqlSession session, int studentNo);

	Student selectStudentOne(SqlSession session, int studentNo);

}
