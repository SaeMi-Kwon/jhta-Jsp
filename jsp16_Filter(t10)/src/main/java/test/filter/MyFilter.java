package test.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/*
 * [ Filter ]
 * - 클라이언트의 요청을 중간에 가로채서 요청페이지로 가기전에 특정 작업을 수행함.
 * 	 수행후 요청페이지로 갈수도 있고 필터에서 다른페이지로 이동도 가능하다.
 * 
 * - 만드는 방법
 * 	1) Filter인터페이스를 상속받아 doFilter메소드에서 필터로 수행할 작업을 구현한다.
 * 	2) web.xml 또는 어노테이션으로 필터가 언제 동작할지에 대한 경로를 매핑한다.
 */

@WebFilter(urlPatterns = {"/member/*"}) //member를 포함한 하위경로를 요청시마다 필터가 동작됨
//@WebFilter(urlPatterns = {"/member/*","/admin/*"})
//@WebFilter(urlPatterns = {"/*"})  //모든페이지를 요청시마다 필터가 호출됨
public class MyFilter implements Filter{
	
	//init메소드 : 필터가 생성될때 딱 한번 호출되는 메소드(디폴트메소드)
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init메소드 호출....");
	}
	
	//doFilter메소드 : 필터가 호출될때마다 호출되는 메소드(추상메소드)
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		
		//요청페이지로 가기전에 해야 할 작업 구현
		System.out.println("doFilter메소드 호출....");
		
		//다음에 수행할 필터가 있으면 필터를 수행하고 더이상 수행할 필터가 없으면 요청페이지로 이동한다
		filterChain.doFilter(req, resp);
		
	}
	
	//destroy메소드 : 필터가 종료될때 호출되는 메소드(디폴트메소드)
	@Override
	public void destroy() {
		System.out.println("destroy메소드 호출....");
	}
}
