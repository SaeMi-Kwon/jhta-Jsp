package test.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

//HttpSessionListener : 세션이 생성되거나 종료될때 이를 처리하는 리스너

@WebListener
public class SessionCountListener implements HttpSessionListener{
	private static int userCount = 0;  //접속자수
	
	public static int getUserCount() {
		return userCount;
	}
	
	//세션이 생성되었을때 호출
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionCreated메소드 호출");
		userCount++;
	}
	
	//세션이 소멸되었을때 호출
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed메소드 호출");
		userCount--;
	}
}
