package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/board/insert","/board/update","/board/delete"}) 
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		boolean login=false;
		
		HttpServletRequest request=(HttpServletRequest)req;
		String id =(String)request.getSession().getAttribute("id");
		
		if(id!=null) {
			login=true;
		}
		
		if(login) {
			chain.doFilter(req, resp);
		}else {
			HttpServletResponse response=(HttpServletResponse)resp;
			response.sendRedirect(request.getContextPath()+"/member/login");
		}
		
		
	}
}
