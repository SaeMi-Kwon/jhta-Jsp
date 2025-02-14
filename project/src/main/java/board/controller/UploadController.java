package board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import dao.BoardDao;
import dto.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10,  //최대업로드파일크기 10mb로 제한
		maxRequestSize = 1024 * 1024 * 50  //최대요청크기 50mb로 제한
)
@WebServlet("/board/insert")
public class UploadController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/board/insertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		String title =req.getParameter("title");
		String content=req.getParameter("content");
		
		try {
			//1.파일 업로드
			
			//경로얻어오기
			String fpath=req.getServletContext().getRealPath("/upload");
			System.out.println("파일저장경로: " + fpath);
			
			//파일정보 읽기
			Part part=req.getPart("f");
			//파일명 읽어오기
			String org=part.getSubmittedFileName();
			//파일크기 읽어오기
			long size=part.getSize();
			//파일 읽어오기
			InputStream is=part.getInputStream();
			
			
			//저장할 파일명(랜덤생성)
			String save=UUID.randomUUID()+"_"+org;
			//서버에 저장
			FileOutputStream fos=new FileOutputStream(fpath+ File.separator + save);
		
			//파일복사
			is.transferTo(fos);
			
			is.close();
			fos.close();
			
			//2.db에 저장
			BoardDto dto=new BoardDto(0,id,title,content,org,save,size);
			BoardDao dao=new BoardDao();
			
			dao.insert(dto);
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//페이지이동
		resp.sendRedirect(req.getContextPath()+"/board/list");
	
	}
}
