package handlers;

import java.util.LinkedHashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * application Event용 Listener 2개 
 *  - ServletContextListener : init, destroy
 *  
 *  - ServletContextAttributeListener : setAttribute, removeAttribute
 * 
 * ※ EventListener는 등록이 필요함. (자동으로 등록되지 않는다)
 * 
 */
@WebListener
public class ApplicationHandler implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		ServletContext ctx = sce.getServletContext();	
		ctx.setRequestCharacterEncoding("UTF-8");
	
	}
}
