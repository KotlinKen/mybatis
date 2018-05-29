package com.kh.emp.controller;

import java.io.IOException;
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
 * Servlet implementation class EmpSearch0Servlet
 */
@WebServlet("/emp/searh1.kh")
public class EmpSearch0Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empservice = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearch0Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.업무로직
		List<Map<String,String>> list = empservice.search0();
		System.out.println("list@controller="+list);
		
		//2.view단
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
