package com.kh.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;

/**
 * Servlet implementation class MybatisTestServlet1
 */
@WebServlet("/test1.do")
public class MybatisTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService = new MybatisServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html, charset=utf-8");
		int result = mybatisService.insertStudent();
		System.out.println("test");
		String msg = result > 0 ? "test1 succed" : "test1 faild ";
		
		response.getWriter().append("Served at: ")
							.append(request.getContextPath())
							.append("<br>"+msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
