package com.kh.mybatis.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiceImpl;
import com.kh.mybatis.model.vo.Student;

/**
 * Servlet implementation class StudentSelectListServlet
 */
@WebServlet("/student/selectList.do")
public class StudentSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MybatisService mybatisService = new MybatisServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		
		if(type != null ) {
			
		}else {
		//1.업무로직
		List<Student> list = mybatisService.selectList();
		System.out.println("list@controller = " + list);
		
		List<Map<String, String>> mapList = mybatisService.selectMapList();
		System.out.println("mapList@controller = " + mapList);
		
		
		
		//2. view단위임
		request.setAttribute("list", list);
		request.setAttribute("mapList", mapList);
		request.getRequestDispatcher("/WEB-INF/views/mybatis/selectList.jsp").forward(request, response);
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
