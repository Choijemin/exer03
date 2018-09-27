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

import models.issueDao;
import models.opinionDao;


@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	/*
	 * ����� ��û�� ���ؼ� �۵����Ѿ� �� �۾���
	 * 		service(HttpServletRequest , HttpServletResponse arg1) : get�� post ó�� 
	 * 		doGet(HttpServletRequest , HttpServletResponse arg1) : get�� ó���ǰ�
	 * 		doPost(HttpServletRequest , HttpServletResponse arg1) : post�� ó����.
	 * 
	 * 	�� �����߿� �ϳ��� �̿��ؼ� �����صθ� �ȴ�
	 * 		
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		opinionDao odo = new opinionDao();
		String talker = (String)session.getAttribute("id");
		List<Map> mys = odo.myissue(talker);
		
		if(session.getAttribute("auth") == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/guest.jsp");
			/*
			 * MVC ����� response �� �����ϱ� ���ؼ� 
			 * �����ϴ� jsp ������ WebContent �ٷ� �Ʒ����ٴ�
			 * WEB-INF ������ ���踦 �صδ� ���̴�. 
			 * ���� ���� ������ �ɸ��� ��ζ� ��� ����ϴ� ���� ��ȣ�� ����. 
			 */
			rd.forward(req, resp);
		} else {
			issueDao ido = new issueDao();
			List<Map> mi = ido.mainissue();
			for(int i = 0; i < mi.size(); i++) {
				Map p = mi.get(i);
				String ctr = (String)p.get("CONTENT");
				if(ctr.contains("\n")) {
					p.put("REP", ctr.substring(0, ctr.indexOf("\n")));
				} else {
					p.put("REP", ctr);
				}
			}
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			session.setAttribute("df", df);
			session.setAttribute("mysize", mys.size());
			session.setAttribute("mys", mys);
			
			session.setAttribute("mainsize", mi.size());
			session.setAttribute("mi", mi);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
			rd.forward(req, resp);
		}
	}
}











