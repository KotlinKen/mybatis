package com.kh.mybatis.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.mybatis.model.vo.Student;

public interface MybatisService {

	int insertStudent();

	int insertStudent(String name);

	int insertStudent(Student st);

	int insertStudent(Map<String, String> map);

	int insertStudent(HashMap<String, Student> map);

	int selectStudentcount();

	String selectStudentName(int studentNo);

	int deletStudent(int studentNo);

	Student searchStudent(int studentNo);

	List<Student> selectList();

	List<Map<String, String>> selectMapList();


}
