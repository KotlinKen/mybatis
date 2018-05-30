package com.kh.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public List<Map<String, String>> search0(SqlSession session) {
		return session.selectList("emp.search0");
	}

	@Override
	public List<Map<String, String>> search1(SqlSession session, Map<String, String> map) {
		return session.selectList("emp.search1", map);
	}

	@Override
	public List<Map<String, String>> search2(SqlSession session, Map<String, String> map) {
		return session.selectList("emp.search2", map);
	}

	@Override
	public List<Map<String, String>> search3(SqlSession session, Map<String, String[]> map) {
		return session.selectList("emp.search3", map);
	}

	@Override
	public List<Map<String, String>> selectEmpList(SqlSession session, int cPage, int numPerPage) {
		//RowBound는 mybatis지원하는 페이징클래스임.
		RowBounds rowBounds = new RowBounds((cPage-1)*numPerPage, numPerPage);		
		return session.selectList("emp.empList", null, rowBounds);
	}

	@Override
	public int selectEmpList(SqlSession session, Map<String, String[]> map) {
		return session.selectOne("emp.search3Count", map);
	}

}
