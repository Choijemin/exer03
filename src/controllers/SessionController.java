package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.AccountDao;
import models.opinionDao;

@WebServlet("/session.do")
public class SessionController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(req.getContextPath()+ "/login.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		
		String id = req.getParameter("id");
		String pass =req.getParameter("pass");
	
		System.out.println(id+"/"+pass);
			
		Map map = new HashMap<>();
		map.put("id", id);
		map.put("pass", pass);
		
		AccountDao acd = new AccountDao();
		Map m = acd.loginck(map);
		
		System.out.println("세션 컨트롤러 "+m);
		
		if(m != null) {
			HttpSession session = req.getSession();
			
			opinionDao odo = new opinionDao();
			List<Map> hot = odo.hotissue();
			for(int i = 0; i < hot.size(); i++) {
				Map p = hot.get(i);
				String ctr = (String)p.get("CONTENT");
				if(ctr.contains("\n")) {
					p.put("REP", ctr.substring(0, ctr.indexOf("\n")));
				} else {
					p.put("REP", ctr);
				}
			}
			SimpleDateFormat af = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			
			session.setAttribute("af", af);
			session.setAttribute("hot", hot);
			session.setAttribute("hotsize", hot.size());
			
			session.setAttribute("auth", true);
			session.setAttribute("id", id);
			resp.sendRedirect(req.getContextPath() + "/index.do");
			
		}else {
			req.setAttribute("err", true);	
			// MVC 패턴 구현시 view 출력시 사용해야될 데이터를 설정하는 영역
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
		}
	}
}