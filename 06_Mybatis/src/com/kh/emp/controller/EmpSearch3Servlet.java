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
 * Servlet implementation class EmpSearch3Servlet
 */
@WebServlet("/emp/search3.kh")
public class EmpSearch3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearch3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.파라미터핸들링
		
		String[] job_codeArr = request.getParameterValues("job_code");
		
		
		
		//2.업무로직
		
		Map<String, String[]> map = new HashMap<>();
		map.put("job_codeArr", job_codeArr);
		System.out.println("RYULMIN CALL - map@controller = " + map);
		List<Map<String,String>>list = empService.search3(map);
		System.out.println("RYULMIN CALL - list@controller = " + list);
		//3.view단 처리위임
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/views/emp/search3.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
