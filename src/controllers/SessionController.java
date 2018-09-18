package controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.AccountDao;

@WebServlet("/session.do")
public class SessionController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.sendRedirect(req.getContextPath()+ "/login.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		HttpSession session = req.getSession();
		
		String id = req.getParameter("id");
		String pass =req.getParameter("pass");
	
		AccountDao acd = new AccountDao();
		Map m = acd.loginck(id);

		if(session.getAttribute(id) == m) {
			req.setAttribute("err", true);	
			req.setAttribute("x", "fail");
			// MVC ���� ������ view ��½� ����ؾߵ� �����͸� �����ϴ� ����
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
		}else {
			session.setAttribute("auth", "pass");
			resp.sendRedirect(req.getContextPath() + "/index.do");
		}
	}
}