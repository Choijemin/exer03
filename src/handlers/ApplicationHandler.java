package handlers;

import java.util.LinkedHashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * application Event�� Listener 2�� 
 *  - ServletContextListener : init, destroy
 *  
 *  - ServletContextAttributeListener : setAttribute, removeAttribute
 * 
 * �� EventListener�� ����� �ʿ���. (�ڵ����� ��ϵ��� �ʴ´�)
 * 
 */
public class ApplicationHandler implements ServletContextListener {
	long begin;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		begin = System.currentTimeMillis();
		/*
		 * �Ű������� �����ִ� ServletContextEvent �� ���ؼ�
		 * application�� �����Ҽ� �ִ�.
		 */
		ServletContext ctx = sce.getServletContext();	
		// JSP���� ���Ǵ� application �̶�� �̸��� ��ü.
		ctx.setRequestCharacterEncoding("UTF-8");	// Listener ������ ����
		// servlet ������������ ���� �޼���
		ctx.setAttribute("users", new LinkedHashSet<>());
	}
}
