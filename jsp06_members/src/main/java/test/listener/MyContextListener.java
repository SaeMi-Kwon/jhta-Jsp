package test.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//ServletContextListener : 컨텍스트가 생성될때 또는 소멸될때 이를 처리하는 리스너
@WebListener
public class MyContextListener implements ServletContextListener {

	//컨텍스트가 생성될때 호출되는 메소드
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized메소드 호출....");
		//서블릿컨텍스트 얻어오기
		ServletContext application=sce.getServletContext();
		application.setAttribute("cp", application.getContextPath());
	}
	
	//컨텍스트가 소멸될때 호출되는 메소드
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed메소드 호출....");
	}
}
