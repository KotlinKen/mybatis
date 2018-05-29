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
 * Servlet implementation class DelectStudentServlet
 */
@WebServlet("/student/deleteStudent.do")
public class DelectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisservice = new MybatisServiseImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelectStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentNo = Integer.parseInt(request.getParameter("no"));
		
		int result = mybatisservice.deletStudent(studentNo);
		
		String msg = result>0?"<h2>퇴학에 성공하였습니다.</h2>":"<h2>퇴학에 실패하였습니다.</h2>";
		
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
