package showM.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import showM.Dao.Dao;
import showM.Dto.BoardDto;

@WebServlet("/contentUpdate")
public class contentUpdateServlet extends HttpServlet {
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
		BoardDto dto = new BoardDto();
		
		String idx = request.getParameter("idx");
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		dao.contentUpdate(dto, idx);
		response.sendRedirect("/board");
	}

}
