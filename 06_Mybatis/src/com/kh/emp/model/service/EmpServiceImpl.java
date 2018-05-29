package com.kh.emp.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.SqlSessionTemplate;
import com.kh.emp.model.dao.EmpDAO;
import com.kh.emp.model.dao.EmpDAOImpl;

public class EmpServiceImpl implements EmpService {
	private EmpDAO empDAO = new EmpDAOImpl();
	@Override
	public List<Map<String, String>> search0() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		
		
		
		return null;
	}

}
