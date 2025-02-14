package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/show")
public class ShowController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies=req.getCookies();
		ArrayList<HashMap<String,String>> list=new ArrayList<HashMap<String,String>>();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				String name=cookie.getName();
				System.out.println("이름:"+name);
				if(name.startsWith("list")) {
					HashMap<String,String> cookieList=new HashMap<String,String>();
					System.out.println("값:"+cookie.getValue());
					cookieList.put("list",cookie.getValue());
					list.add(cookieList);
				}
			}
		}
		
		
		
		req.setAttribute("cookies", list);
		req.getRequestDispatcher("/board/show.jsp").forward(req, resp);
	}
}
