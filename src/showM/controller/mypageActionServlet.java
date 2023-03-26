package showM.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import showM.Dao.Dao;
import showM.Dto.JoinDto;

/**
 * Servlet implementation class mypageActionServlet
 */
@WebServlet("/mypageActionServlet")
public class mypageActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		Dao dao = new Dao();
		
		JoinDto dto = new JoinDto();
		
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String idd = request.getParameter("id");
		
		dto.setPassword(password);
		dto.setName(name);
		dto.setEmail(email);
		dto.setId(idd);
		
		dao.myUpdate(dto);
		
		out.println("<script>");
		out.println("alert('수정 완료!!')");
		out.println("location.href='/index'");
		out.println("</script>");
	}

}
