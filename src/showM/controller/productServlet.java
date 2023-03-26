package showM.controller;

import java.io.IOException;
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
 * Servlet implementation class productServlet
 */
@WebServlet("/product")
public class productServlet extends HttpServlet {
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
		Dao dao = new Dao();
		
		String id = (String) session.getAttribute("id");
		String idx = request.getParameter("idx");
		
		Dto dto = dao.getProduct(idx);
		List<Dto> dtoo = dao.LimitSel();
		
		request.setAttribute("dto", dto);
		request.setAttribute("dtoo", dtoo);
		RequestDispatcher dis = request.getRequestDispatcher("product.jsp");
		dis.forward(request, response);
				
	}

}
