package com.kh.emp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public interface EmpDAO {

	List<Map<String, String>> search0(SqlSession session);

	List<Map<String, String>> search1(SqlSession session, Map<String, String> map);

	List<Map<String, String>> search2(SqlSession session, Map<String, String> map);

}
