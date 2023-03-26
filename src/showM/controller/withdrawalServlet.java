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

@WebServlet("/withdrawal")
public class withdrawalServlet extends HttpServlet {
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
		dao.Withdrawal(id);
		
		out.println("<script>");
		out.println("alert('탈퇴가 완료되었습니다.')");
		out.println("location.href='/index'");
		out.println("</script>");
		
		session.invalidate();
	}

}
