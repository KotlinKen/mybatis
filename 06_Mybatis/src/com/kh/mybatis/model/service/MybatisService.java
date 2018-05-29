package com.kh.mybatis.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.mybatis.model.vo.Student;

public interface MybatisService {
	int insertStudent();
	int insertStudent(String name);
	int insertStudent(Student student);
	int insertStudent(Map<String, String> map);
	int insertStudent(HashMap<String, Student> map);
	int selectStudentCount();
	String selectStudentName(int studentNo);
	int deleteOne(int studentNo);
	Student selectStudentOne(int studentNo);
	List<Student> selectList();
	List<Map<String, String>> selectMapList();
}