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
 * Servlet implementation class StudentDeleteOneServlet
 */
@WebServlet("/student/deleteStudent.do")
public class StudentDeleteOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService = new MybatisServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		int studentNo = Integer.parseInt(request.getParameter("no"));
		System.out.println(studentNo);
		
		
		int result = mybatisService.deleteOne(studentNo);
		
		
		
		
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc ="/WEB-INF/views/mybatis/selectOne.jsp";
		
		
			
		if(result > 0 ) {
			msg = "성공입니다.";
		}else {
			msg = "실패입니다.";
		}
		
		
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
		
		
		request.getRequestDispatcher(view).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
