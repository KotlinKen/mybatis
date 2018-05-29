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

import com.kh.emp.service.EmpService;
import com.kh.emp.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpSearch1Servlet
 */
@WebServlet("/emp/search2.kh")
public class EmpSearch2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService emp = new EmpServiceImpl();
       
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
		//1.인코딩 처리
		
		
		//2.파라미터핸들링
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		String gender = request.getParameter("gender");
		Map<String,String> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("searchKeyword", searchKeyword);
		map.put("gender", gender);
		System.out.println("map@controller="+map);
		
		//3.업무로직
		List<Map<String,String>> list = emp.search2(map);
		System.out.println("List@controller="+list);
		
		//4.view단 위임
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
