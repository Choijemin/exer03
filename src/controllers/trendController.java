package controllers;

import java.io.IOException;
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

import models.issueDao;

@WebServlet("/trend.do")
public class trendController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		issueDao ido = new issueDao();
		
		List<Map> li = ido.allTrend();
		for(int i = 0; i <li.size(); i++) {
			Map p = li.get(i);
			String ctr = (String)p.get("CONTENT");
			if(ctr.contains("\n")) {
				p.put("REP", ctr.substring(0, ctr.indexOf("\n")));
			} else {
				p.put("REP", ctr);
			}
		}
		req.setAttribute("li", li);
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/issue/trend.jsp");
		rd.forward(req, resp);
	}
}