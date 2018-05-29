package com.kh.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.model.service.MybatisService;
import com.kh.mybatis.model.service.MybatisServiseImpl;

/**
 * Servlet implementation class MybatisTestServlet
 */
@WebServlet("/test1.do")
public class MybatisTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MybatisService mybatisService = new MybatisServiseImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비지닌스 로직 처리
		System.out.println("test1.do 실행 들어 오는가?");
		int result = mybatisService.insertStudent();
		System.out.println("test1.do 실행 들어 오는가?");
		String msg = result>0?"test1성공":"test1실패";
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("<br>"+msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
