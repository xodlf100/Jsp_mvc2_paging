package showM.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import showM.Dao.Dao;
import showM.Dto.Dto;

/**
 * Servlet implementation class serahchServlet
 */
@WebServlet("/search")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		Dao dao = new Dao();
		
		String word = request.getParameter("keyword");
		List<Dto> dto = dao.search(word);
	
		request.setAttribute("ser", dto);
		RequestDispatcher dis = request.getRequestDispatcher("search.jsp");
		dis.forward(request, response);
	}

}
