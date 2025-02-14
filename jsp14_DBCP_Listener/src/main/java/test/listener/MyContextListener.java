package test.listener;

import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import test.db.ConnectionPool;

//ServletContextListener : 컨텍스트가 생성될때 또는 소멸될때 이를 처리하는 리스너
//@WebListener
public class MyContextListener implements ServletContextListener {
	ConnectionPool conPool;
	
	//컨텍스트가 생성될때 호출되는 메소드
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized메소드 호출....");
		
		try {
			conPool=new ConnectionPool();
			System.out.println("컨넥션 풀 생성...");
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		//서블릿컨텍스트 얻어오기
		ServletContext application=sce.getServletContext();
		application.setAttribute("cp", application.getContextPath());
		application.setAttribute("conPool", conPool);
		
	}
	
	//컨텍스트가 소멸될때 호출되는 메소드
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed메소드 호출....");
		
		try {
			conPool.closeAll();
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
}
