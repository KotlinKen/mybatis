package com.kh.mybatis.model.dao;

import org.apache.ibatis.session.SqlSession;

public interface MybatisDAO {
	
	int insertStudent(SqlSession session);

}
