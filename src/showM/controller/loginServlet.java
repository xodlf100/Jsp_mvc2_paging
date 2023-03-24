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
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Dao dao = new Dao();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int result = dao.login(id, password);
		
		if(result == 1) {
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setMaxInactiveInterval(60*10);
			
			out.println("<script>");
			out.println("alert('로그인 성공')");
			out.println("</script>");
			
			response.sendRedirect("index.jsp");
//			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
////			request.setAttribute("key", value); Dispatcher �� �� �����͸� �ش� �������� �Ѱ��� �� ����
//			dis.forward(request, response);
		}
		if(result == 0){
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
		
}
