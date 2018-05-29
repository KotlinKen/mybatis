package com.kh.mybatis.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public interface MybatisDAO {

	int insertStudent(SqlSession session);

	int insertStudent(String name, SqlSession session);

	int insertStudent(Student st, SqlSession session);

	int insertStudent(SqlSession session, Map<String, String> map);

	int insertStudent(SqlSession session, HashMap<String, Student> map);

	int selectStudentcount(SqlSession session);

	String selectStudentName(int studentNo, SqlSession session);

	int deletStudent(SqlSession session, int studentNo);

	Student searchStudent(int studentNo, SqlSession session);

	List<Student> selectList(SqlSession session);

	List<Map<String, String>> selectMapList(SqlSession session);

}
