package com.kh.mybatis.model.dao;
import org.apache.ibatis.session.SqlSession;


public class MybatisDAOImpl implements MybatisDAO {

	@Override
	public int insertStudent(SqlSession session) {
		// mybatis : namespace, test1 : id
		int result = session.insert("mybatis.test1");
		
		System.out.println("result@DAO= " + result);
		
		return result;
	}

}
