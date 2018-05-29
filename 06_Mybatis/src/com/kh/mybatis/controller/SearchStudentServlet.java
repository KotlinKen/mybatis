package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiseImpl;
import com.kh.mybatis.model.vo.Student;


/**
 * Servlet implementation class SearchStudentServlet
 */
@WebServlet("/student/searchStudent.do")
public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisservice = new MybatisServiseImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("???");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		System.out.println("studentNO : "+ studentNo);
		
		//1.업무로직처리
		Student s = null;
		s = mybatisservice.searchStudent(studentNo);
		
		System.out.println("s.getStudentName(); "+	s.getStudentName());
		//2.응답객체 출력
		response.setContentType("application/json; charset=utf-8");
		
		new Gson().toJson(s, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
