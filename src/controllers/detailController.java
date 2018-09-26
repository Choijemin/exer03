package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.issueDao;
import models.opinionDao;


@WebServlet("/detail.do")
public class detailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int no = Integer.parseInt(req.getParameter("no"));
		issueDao ido = new issueDao();
		opinionDao odao = new opinionDao();
		List<Map> opinions = odao.getSomeByIno(no);
		Map a = ido.getDetail(no);
		List<Map> agr = odao.sumagree();
	
		if(a == null) {
			resp.sendRedirect(req.getContentType() + "/trend.do");
		}else {
		HttpSession session = req.getSession();
		
		session.setAttribute("id", session.getAttribute("id"));
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/issue/detail.jsp");
		req.setAttribute("issue", a);
		req.setAttribute("opinions", opinions);
		req.setAttribute("sumagree", agr);
		rd.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
