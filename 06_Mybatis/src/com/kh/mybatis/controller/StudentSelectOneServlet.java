package com.kh.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiseImpl;

/**
 * Servlet implementation class StudentSelectOneServlet
 */
@WebServlet("/student/selectOne.do")
public class StudentSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisservice = new MybatisServiseImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.파라미터 핸들링
		int studentNo = 0;
		try {
			studentNo = Integer.parseInt(request.getParameter("no"));
			
		} catch (Exception e) {
		}
		
		//1.1.비지니스 로직 : 전체학생수 구하기
		int count = mybatisservice.selectStudentcount();
		
		//1.2 비지니스로직 : 학생이름 구하기
		String studentName = "";
		if(studentNo!=0) {
			studentName = mybatisservice.selectStudentName(studentNo);
		}
		
		//2. view단
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setAttribute("count", count);
		request.setAttribute("studentName", studentName);
		request.getRequestDispatcher("/WEB-INF/views/mybatis/selectOne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
