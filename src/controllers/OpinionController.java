package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import models.opinionDao;

@WebServlet("/issue/opinion.do")
public class OpinionController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ino 값을 parameter 넘겨줬을 때 그 ino로 등록된 opinion들 뽑아서
		// JSON으로 응답보내게 이 컨트롤러의 get을 구현
		int ino = Integer.parseInt(req.getParameter("ino"));
		opinionDao odao = new opinionDao();
		List<Map> li = odao.getSomeByIno(ino);
		Gson gson = new Gson();
		String json = gson.toJson(li);
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(json);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getContentType());
		
		HttpSession session = req.getSession();

		String choice = req.getParameter("choice");
		String ment = req.getParameter("ment");
		String ino = req.getParameter("ino");
		
		// Map user = (Map)session.getAttribute("id");
		String talker = (String)session.getAttribute("id");
	
		
		Map m = new HashMap<>();
		m.put("choice", choice);
		m.put("ment", ment);
		m.put("ino", ino);
		m.put("talker", talker);
		opinionDao oDao = new opinionDao();
		int r = oDao.addOne(m);
		System.out.println(m.toString() +"▷▷▷ "+r);
		
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(r==1) {
			out.println("{\"rst\":true}");
		}else {
			out.println("{\"rst\":false}");
		}
		
		
	}
	


}
