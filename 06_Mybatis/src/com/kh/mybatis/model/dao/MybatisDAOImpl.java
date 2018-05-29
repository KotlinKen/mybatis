package com.kh.mybatis.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Student;

public class MybatisDAOImpl implements MybatisDAO {

	@Override
	public int insertStudent(SqlSession session) {
		System.out.println("10");
		int result = session.insert("mybatis.test1");
		System.out.println("result@DAO : "+result );
		return result;
	}

	@Override
	public int insertStudent(String name, SqlSession session) {
		System.out.println("??");
		//int org.apache.ibatis.session.SqlSession.insert(String arg0, Object arg1)
		return session.insert("mybatis.test2",name);
	}

	@Override
	public int insertStudent(Student st, SqlSession session) {
		System.out.println("insert : "+st );
		return session.insert("mybatis.test3",st);
	}

	@Override
	public int insertStudent(SqlSession session, Map<String, String> map) {
		
		return session.insert("mybatis.test4",map);
	}

	@Override
	public int insertStudent(SqlSession session, HashMap<String, Student> map) {
		return session.insert("mybatis.test5",map);
	}

	@Override
	public int selectStudentcount(SqlSession session) {
		
		return session.selectOne("mybatis.selectStudentCount");
	}

	@Override
	public String selectStudentName(int studentNo, SqlSession session) {
		return session.selectOne("mybatis.selectStudentName",studentNo);
	}

	@Override
	public int deletStudent(SqlSession session, int studentNo) {
		System.out.println("DAO");
		return session.delete("mybatis.deleteStudent",studentNo);
	}

	@Override
	public Student searchStudent(int studentNo, SqlSession session) {
		//sultType을 이용한 StudentVO가져오기
		//session.selectOne("mybatis.searchStudent",studentNo)
		
		//resultMap을 이용한 StudentVO가져오기
		Student s = session.selectOne("mybatis.searchStudent_",studentNo);
		System.out.println("@DAO : "+studentNo);
		return s;
	}

	@Override
	public List<Student> selectList(SqlSession session) {
		//리스트 호출
		return session.selectList("mybatis.selectList");
	}

	@Override
	public List<Map<String, String>> selectMapList(SqlSession session) {
		
		return session.selectList("mybatis.selectMapList");
	}

}
