package com.kh.mybatis.model.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public interface MybatisDAO {
	
	int insertStudent(SqlSession session);

	int insertStudent(SqlSession session, String name);

	int insertStudent(SqlSession session, Student student);

	int insertStudent(SqlSession session, Map<String, String> map);

}
