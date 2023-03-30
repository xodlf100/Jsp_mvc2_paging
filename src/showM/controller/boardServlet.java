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
import showM.Dto.BoardDto;
import showM.Dto.Paging;

@WebServlet("/board")
public class boardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		Dao dao = new Dao();
		
		 
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int page = Integer.parseInt(pageNum);
		
		Paging paging = new Paging();
		paging.setCurrentPage(page); // LIMIT(앞)
		paging.setStartValue((page-1)*paging.getPerPageNum()); // LIMIT(뒤)
		int count = dao.boardAll(); // 전체 게시글 조회\
		System.out.println("전체글---->"+ count);
		
		paging.setRealPage( (int) Math.ceil(count / (double) paging.getPerPageNum())); // 마지막 페이지로 만들어주기
		
		// 뭘 보든 끝페이지 남기기 ex) 6 클릭해도 1~10, 13 클릭해도 11~20
		paging.setEndNum( (int) (Math.ceil(paging.getCurrentPage() / (double) paging.getDisPageNum()) * paging.getDisPageNum())); 
		paging.setStartNum(paging.getEndNum() - paging.getDisPageNum() + 1);
		
		// ex) 마지막 페이지를 보고 있으면 endnum을 재셋팅해줌.
		if(paging.getRealPage() < paging.getEndNum()) {
			paging.setEndNum(paging.getRealPage()); 
		}
		
		
		if(paging.getStartNum() != 1) {
			paging.setPrev(true);
		}
		if(paging.getEndNum() < paging.getRealPage()){
			paging.setNext(true);
		}
		
		System.out.println(paging.getRealPage());
		System.out.println(paging.getStartNum());
		System.out.println(paging.getEndNum());
		
		request.setAttribute("paging", paging);
		
		List<BoardDto> dto = dao.boardSelectAll(paging);
		request.setAttribute("a", dto);
		request.setAttribute("id", id);
		
		RequestDispatcher dis = request.getRequestDispatcher("board.jsp");
		dis.forward(request, response);
	}

}
