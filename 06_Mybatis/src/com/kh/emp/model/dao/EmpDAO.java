package com.kh.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDAO {

	List<Map<String, String>> search0(SqlSession session);

	List<Map<String, String>> search1(SqlSession session, Map<String, String> map);

	List<Map<String, String>> search2(SqlSession session, Map<String, String> map);

	List<Map<String, String>> search3(SqlSession session, Map<String, String[]> map);

	List<Map<String, String>> selectEmpList(SqlSession session, int cPage, int numPerPage);

	int selectEmpList(SqlSession session, Map<String, String[]> map);
	
}
