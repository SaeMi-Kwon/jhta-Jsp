package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class WeatherController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String day=req.getParameter("day");
		String result="";
		
		if(day.equals("1")) {
			result="오늘날씨 : 너무너무 추워요!";
		}else if(day.equals("2")) {
			result="내일날씨 : 눈이 많이 와요@";
		}
		req.setAttribute("result", result);  //값 담기
		
		// /1/showWeather.jsp 파일을 완성해 보세요.
		req.getRequestDispatcher("/1/showWeather.jsp").forward(req, resp); //페이지이동
	}
}
