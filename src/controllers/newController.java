package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.issueDao;

@WebServlet("/new.do")
public class newController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/issue/new.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String cate = req.getParameter("cate");
		String content = req.getParameter("content");
		String agree = req.getParameter("agree");
		String disagree = req.getParameter("disagree");
		//long date = session.getCreationTime();
		
		issueDao isd = new issueDao();
		Map m = new HashMap<>();
		m.put("cate", cate);
		m.put("content", content);
		m.put("agree", agree);
		m.put("disagree", disagree);
		m.put("writer", session.getAttribute("id"));
		//m.put("regdate", date);
		
		int i = isd.addIssue(m);
		
		System.out.println(i);
		
		if(i == 1) {
			 resp.sendRedirect(req.getContextPath()+"/trend.do");
			 
		} else {
			req.setAttribute("err", true);
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/issue/new.jsp");
			rd.forward(req, resp);
		}
	}
}
