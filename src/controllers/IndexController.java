package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	/*
	 * 사용자 요청에 의해서 작동시켜야 될 작업을
	 * 		service(HttpServletRequest , HttpServletResponse arg1) : get과 post 처리 
	 * 		doGet(HttpServletRequest , HttpServletResponse arg1) : get만 처리되고
	 * 		doPost(HttpServletRequest , HttpServletResponse arg1) : post만 처리됨.
	 * 
	 * 	이 세개중에 하나를 이용해서 구현해두면 된다
	 * 		
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("auth") == null) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			/*
			 * MVC 구축시 response 를 전송하기 위해서 
			 * 설계하는 jsp 파일은 WebContent 바로 아래보다는
			 * WEB-INF 안으로 설계를 해두는 편이다. 
			 * 직접 접근 차단이 걸리는 경로라서 뷰로 사용하는 파일 보호를 위해. 
			 */
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
			rd.forward(req, resp);
		}
	}
}











