package com.kh.emp.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.emp.model.dao.EmpDAO;
import com.kh.emp.model.dao.EmpDAOImpl;
import com.kh.mybatis.model.vo.Student;

public class EmpServiceImpl implements EmpService {
	private EmpDAO empDAO = new EmpDAOImpl();
	
	
	@Override
	public List<Map<String, String>> search0() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		List<Map<String, String>> list = empDAO.search0(session);
		System.out.println(list);
		session.close();
		
		return list;
	}


	@Override
	public List<Map<String, String>> search1(Map<String, String> map) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		List<Map<String, String>> list = empDAO.search1(session, map);
		System.out.println(list);
		session.close();
		
		return list;
	}


	@Override
	public List<Map<String, String>> search2(Map<String, String> map) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Map<String, String>> list = empDAO.search2(session, map);
		System.out.println(list);
		session.close();
		
		return list;
	}


	@Override
	public List<Map<String, String>> search3(Map<String, String[]> map) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Map<String, String>> list = empDAO.search3(session, map);
		System.out.println(list);
		session.close();
		
		return list;
	}


	@Override
	public List<Map<String, String>> selectEmpList(int cPage, int numPerPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Map<String, String>> list = empDAO.selectEmpList(session, cPage, numPerPage);
		System.out.println(list);
		session.close();
		
		return list;
	}


	@Override
	public int search3Count(Map<String, String[]> map) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int totalCount = empDAO.selectEmpList(session, map);
		session.close();
		
		return totalCount;
		
	}

}
