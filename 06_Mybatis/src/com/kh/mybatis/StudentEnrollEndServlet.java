package com.kh.mybatis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiseImpl;
import com.kh.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentEnrollEndServlet
 */
@WebServlet("/student/studentEnrollEnd.do")
public class StudentEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisservice = new MybatisServiseImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String studentName = request.getParameter("studentName");
		String studentTel = request.getParameter("studentTel");
		String studentEmail = request.getParameter("studentEmail");
		String studentAddr = request.getParameter("studentAddr");
		
		Student st = new Student(0,studentName,studentTel,studentEmail,studentAddr,null);
		
		int result = mybatisservice.insertStudent(st);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
