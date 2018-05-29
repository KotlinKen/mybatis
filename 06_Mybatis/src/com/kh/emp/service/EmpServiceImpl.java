package com.kh.emp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.emp.dao.EmpDAO;
import com.kh.emp.dao.EmpDAOImpl;

public class EmpServiceImpl implements EmpService {
	private EmpDAO empdao = new EmpDAOImpl();
	@Override
	public List<Map<String, String>> search0() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Map<String, String>> list = empdao.search0(session);
		session.close();
		return list;
	}
	
	@Override
	public List<Map<String, String>> search1(Map<String, String> map) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Map<String, String>> list = empdao.search1(session,map);
		session.close();
		return list;
	}

	@Override
	public List<Map<String, String>> search2(Map<String, String> map) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Map<String, String>> list = empdao.search2(session,map);
		session.close();
		return list;
	}

}
