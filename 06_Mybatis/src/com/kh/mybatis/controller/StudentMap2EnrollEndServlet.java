package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiseImpl;
import com.kh.mybatis.model.vo.Student;


/**
 * Servlet implementation class StudentMapEnrollEndServlet
 */
@WebServlet("/student/studentMap2EnrollEnd.do")
public class StudentMap2EnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisservice = new MybatisServiseImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMap2EnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//파라미터 핸들링
		String studentName = request.getParameter("studentName");
		String studentTel = request.getParameter("studentTel");
		String studentEmail = request.getParameter("studentEmail");
		String studentAddr = request.getParameter("studentAddr");
		
		//업무로직
		Student s = new Student(0,studentName,studentTel,studentEmail,studentAddr,null);
		
		HashMap<String, Student> map = new HashMap<>();
		map.put("student",s);
		
		//제네릭의 오버로딩은 인정되지 않으므로, Map<String,String>와 Map<String,Student>의 오버로딩은 성립 불가
		int result = mybatisservice.insertStudent(map);
	
		String msg = result>0?"<h2>학생등록성공</h2>":"<h2>학생등록실패</h2>";
		
		response.getWriter().append(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
