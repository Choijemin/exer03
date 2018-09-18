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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String id = req.getParameter("id");
		String pass =req.getParameter("pass");
	
		AccountDao acd = new AccountDao();
		Map m = acd.loginck(id);
		
		
		if(!acd.loginck("PASS").equals(pass)) {
			req.setAttribute("err", true);	
			req.setAttribute("x", "fail");
			// MVC 패턴 구현시 view 출력시 사용해야될 데이터를 설정하는 영역
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
			
		}else {
			
			HttpSession session = req.getSession();
			session.setAttribute("auth", "pass");
			resp.sendRedirect(req.getContextPath()+ "/index.do");
		}
	}
	
}