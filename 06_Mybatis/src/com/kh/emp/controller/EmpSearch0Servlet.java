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
 * Servlet implementation class EmpSearch0Servlet
 */
@WebServlet("/emp/search0.kh")
public class EmpSearch0Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmpService empService = new EmpServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearch0Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.업무로직
		List<Map<String, String>> list = empService.search0();
		System.out.println("list@controller");
		
		
		
		
		
		//2.비지니스 처리
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/emp/search1.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
