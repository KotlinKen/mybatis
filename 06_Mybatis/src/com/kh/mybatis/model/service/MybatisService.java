package com.kh.mybatis.model.service;

import java.util.Map;

import com.kh.mybatis.model.vo.Student;

public interface MybatisService {
	int insertStudent();
	int insertStudent(String name);
	int insertStudent(Student student);
	int insertStudent(Map<String, String> map);
}