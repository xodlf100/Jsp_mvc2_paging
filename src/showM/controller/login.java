package showM.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import showM.Dao.Dao;
import sun.rmi.server.Dispatcher;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		reqPro(request, response, session);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		reqPro(request, response, session);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		System.out.println("ttt");
		Dao dao = new Dao();
		request.setCharacterEncoding("UTF-8");
		PrintWriter script = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		int result = dao.login(id, password);
		
		request.setAttribute("result", result);
		

		RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
		dis.forward(request, response);
		
	}
}
