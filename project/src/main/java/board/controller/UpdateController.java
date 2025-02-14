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
import jakarta.servlet.http.Part;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 10,  //최대업로드파일크기 10mb로 제한
		maxRequestSize = 1024 * 1024 * 50  //최대요청크기 50mb로 제한
)
@WebServlet("/board/update")
public class UpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=Integer.parseInt(req.getParameter("filenum"));
		String id=(String)req.getSession().getAttribute("id");
		
		BoardDao dao=new BoardDao();
		boolean n=dao.check(num,id);
		
		if(n) { //일치하면
			BoardDto dto=dao.findByNum(num);	
			req.setAttribute("dto", dto);
			req.getRequestDispatcher("/board/updateForm.jsp").forward(req, resp);
			
		}else {
			BoardDto dto=dao.findByNum(num);
			String writer=dto.getWriter();
			req.setAttribute("writer", writer);
			req.setAttribute("msg", "로그인사용자과 작성자가 일치하지않습니다.");
			req.getRequestDispatcher("/board/result.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=(String)req.getSession().getAttribute("id");
		int num=Integer.parseInt(req.getParameter("filenum"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		//파일정보 읽기
		Part part=req.getPart("fu");
		long size=part.getSize();
		
		BoardDao dao= new BoardDao();
		BoardDto vo=dao.findByNum(num);
		
		//db에 저장되어있는 기존에 전송되었던 파일정보 얻어오기
		long fsize=vo.getFilesize(); 
		String org=vo.getOrgfilename();
		String save=vo.getSavefilename();
		

		if(size!=0){  //수정할 파일이 전송된 경우
			String path=req.getServletContext().getRealPath("/upload");
			
			//기존 파일 삭제
			File delfile = new File(path + File.separator + save);
			delfile.delete();
			
			//전송된 파일정보
			org=part.getSubmittedFileName();
			fsize=part.getSize();
			save=UUID.randomUUID()+"_"+org;

			InputStream is=part.getInputStream();
			FileOutputStream fos=new FileOutputStream(path + File.separator + save);
			
			is.transferTo(fos);
			
			is.close();
			fos.close();

		}else {  //기존 파일정보 유지
		
		}
		
		//db수정하기
		BoardDto dto=new BoardDto(num,null,title,content,org,save,fsize);
		dao.update(dto);
		
		resp.sendRedirect(req.getContextPath()+"/board/detail?filenum="+num);
	}
	
	
}
