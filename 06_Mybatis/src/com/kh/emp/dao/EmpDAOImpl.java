package com.kh.emp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public List<Map<String, String>> search0(SqlSession session) {
		return session.selectList("emp.selectMapList");
	}

	@Override
	public List<Map<String, String>> search1(SqlSession session, Map<String, String> map) {
		return session.selectList("emp.search1",map);
	}

	@Override
	public List<Map<String, String>> search2(SqlSession session, Map<String, String> map) {
		System.out.println("DAO@map="+map);
		return session.selectList("emp.search2",map);
	}

}