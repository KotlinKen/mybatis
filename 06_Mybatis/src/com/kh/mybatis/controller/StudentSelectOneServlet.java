package com.kh.mybatis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;
import com.kh.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentSelectOneServlet
 */
@WebServlet("/student/selectOne.do")
public class StudentSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService = new MybatisServiceImpl();
       
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
		
		String type = request.getParameter("type");
		
		int studentNo = 0; 
		try {
			studentNo = Integer.parseInt(request.getParameter("no"));
		}catch(NumberFormatException e) {
			
		}
		
		if(type == null) {

			
			//1.1 비지니스로직 : 전체학생수 구하기
			int count = mybatisService.selectStudentCount();
			//1.2 비지니스 로직 : 학생이름 구하기
			String studentName = "";
			if(studentNo !=0) {
				studentName = mybatisService.selectStudentName(studentNo);
				
			}
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			request.setAttribute("count", count);
			request.setAttribute("studentName", studentName);
			request.getRequestDispatcher("/WEB-INF/views/mybatis/selectOne.jsp").forward(request, response);
		
		}else {
			if("ajaxSelectOne".equals(type)) {
				System.out.println(studentNo);
				
				Student s = mybatisService.selectStudentOne(studentNo);
				
				System.out.println(s+"test");
				
				
				response.setContentType("application/json; charset=utf-8");
				new Gson().toJson(s, response.getWriter());
				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
