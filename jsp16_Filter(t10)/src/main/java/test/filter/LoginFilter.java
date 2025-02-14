package test.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/member/*"})
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		boolean login=false;
		
		//1.세션에 id가 있는지 검사
		//세션에 id가 존재하면 login변수에 true, id가 존재하지 않으면 false가 저장되도록 코드를 작성해 보세요.
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session=request.getSession();
		
		String id=(String)session.getAttribute("id");
		
		if(id!=null) {  //로그인된 상태
			login=true;
		}
		
		//2.id가 존재하면 요청페이지로 이동/ id가 없으면 로그인페이지로 이동
		if(login) {
			chain.doFilter(req, resp);
		}else {
			HttpServletResponse response=(HttpServletResponse)resp;
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
	}
}
