package showM.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import showM.Dao.Dao;
import showM.Dto.BoardDto;

@WebServlet("/writeAction")
public class writeActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charser=UTF-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		Dao dao = new Dao();
		BoardDto dto = new BoardDto();
		
		
		dto.setTitle(request.getParameter("title"));
		dto.setJoinName(id);
		dto.setContent(request.getParameter("content"));
		
		dao.write(dto);
		System.out.println(dto);
		response.sendRedirect("/board");
	}

}
