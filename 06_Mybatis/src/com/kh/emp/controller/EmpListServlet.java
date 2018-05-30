package com.kh.emp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.emp.model.service.EmpService;
import com.kh.emp.model.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/empList.kh")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 파라미터 핸들링
		int numPerPage = 5; //한페이지당 게시물수 
		int cPage; //요청 페이지

		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (NumberFormatException e) {
			cPage = 1; 
		}
		//2. 업무로직
		
		List<Map<String, String>> list = empService.selectEmpList(cPage, numPerPage);
		System.out.println("list@controller="+list);
		
		//3.view단 포워딩
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/emp/empList.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
