package controllers;

import java.awt.Window;
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

import models.AccountDao;

@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("id", "");
		req.setAttribute("pass", "");
		req.setAttribute("name", "");
		req.setAttribute("gender", "");
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/join.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		
		AccountDao acd = new AccountDao();
		Map deta = new HashMap();
		deta.put("id", id);
		deta.put("pass", pass);
		deta.put("name", name);
		deta.put("gender", gender);
		
		int j = acd.addAccount(deta);
	
		HttpSession session = req.getSession();
		
		if(j == 1) {
			resp.sendRedirect(req.getContextPath()+ "/index.do");
		} else {
			
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/join.jsp");
			rd.forward(req, resp);
		}
		
	}
}
