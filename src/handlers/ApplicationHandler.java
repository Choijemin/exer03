package handlers;

import java.util.LinkedHashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * application Event�� Listener 2�� 
 *  - ServletContextListener : init, destroy
 *  
 *  - ServletContextAttributeListener : setAttribute, removeAttribute
 * 
 * �� EventListener�� ����� �ʿ���. (�ڵ����� ��ϵ��� �ʴ´�)
 * 
 */
@WebListener
public class ApplicationHandler implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// ����̹� �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ServletContext ctx = sce.getServletContext();	
		ctx.setRequestCharacterEncoding("UTF-8");
	
	}
}
