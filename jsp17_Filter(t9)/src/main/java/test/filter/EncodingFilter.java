package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

//@WebFilter("/*")
//@WebFilter(urlPatterns= {"/*"})
@WebFilter(
		urlPatterns = {"/*"},  //필터 매핑경로 설정
		initParams = {  //초기화 파라미터값 설정
				@WebInitParam(name="encoding",value="utf-8")
		}
)
public class EncodingFilter implements Filter{
	String encoding=null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//초기화 파라미터값 읽어오기
		encoding=filterConfig.getInitParameter("encoding");
		System.out.println("설정할 인코딩:" + encoding);
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("인코딩필터 호출...");
		//req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
		
	}
	
}
