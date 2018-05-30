package com.kh.emp.controller;

import java.io.IOException;
import java.util.HashMap;
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
 * Servlet implementation class EmpSearch1Servlet
 */
@WebServlet("/emp/search2.kh")
public class EmpSearch2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearch2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1.인코딩처리 
		request.setCharacterEncoding("utf-8");
		
		//2.파라미터 처리 
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		String gender = request.getParameter("gender");
		//급여기준 추가
		String salary = request.getParameter("salary");
		String salary_le_ge = request.getParameter("salary_le_ge");
		//고용일기준 추가 
		String hire_date = request.getParameter("hire_date");
		String hire_date_le_ge = request.getParameter("hire_date_le_ge");
		
		Map<String, String> map = new HashMap<>();
		
		map.put("searchType", searchType);
		map.put("searchKeyword", searchKeyword);
		map.put("gender", gender);
		map.put("salary", salary);
		map.put("salary_le_ge", salary_le_ge);
		map.put("hire_date", hire_date);
		map.put("hire_date_le_ge", hire_date_le_ge);
		System.out.println("map@controller="+map);
		
		
		List<Map<String,String>> list = empService.search2(map);
		System.out.println("list@controller = " + list);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/emp/search2.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
