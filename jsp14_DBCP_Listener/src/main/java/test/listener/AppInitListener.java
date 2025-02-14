package test.listener;

import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import members.dao.MembersDao;
import test.db.ConnectionPool;

@WebListener
public class AppInitListener implements ServletContextListener{
	ConnectionPool pool=null;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized 메소드 호출!");
		
		try {
			pool=new ConnectionPool();
			ServletContext sc=sce.getServletContext();
			sc.setAttribute("pool", pool);
			sc.setAttribute("membersDao", new MembersDao(pool));
			sc.setAttribute("cp", sc.getContextPath());
		
		}catch(SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed 메소드 호출!");
		
		try {
			pool.closeAll();
			System.out.println("모든 컨넥션이 접속이 해제됨..");
		
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
