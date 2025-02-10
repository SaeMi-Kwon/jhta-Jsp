package test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.dao.FileInfoDao;
import test.dto.FileInfoDTO;

@WebServlet("/file/download")
public class FiledownloadController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//다운로드할 파일에 대한 정보 얻어오기(다운로드할 파일명/파일크기)
		int filenum=Integer.parseInt(req.getParameter("filenum"));
		
		FileInfoDao dao = new FileInfoDao();
		FileInfoDTO dto=dao.detail(filenum);
		
		String orgfilename=dto.getOrgfilename();
		String savefilename=dto.getSavefilename();
		long filesize=dto.getFilesize();
		
		//////////////////////////   1. 다운로드 창으로 응답하기   ////////////////////////////////
		//다운로드할 창에 보여질 파일이름(파일명이 한글인 경우 깨질수 있으므로 utf-8로 인코딩한다.)
		String filename=URLEncoder.encode(orgfilename,"utf-8");  //import java.net.URLEncoder;
		// -> 인코딩으로 변환할경우 공백이 +로 바뀐다
		
		//+문자를 공백문자(%20)으로 변환하기
		filename=filename.replaceAll("\\+", "%20");
		
		//다운로드창으로 응답하겠다 (클라이언트가 파일을 실제로 다운로드하도록 유도)
		//resp.setContentType("text/html;charset=utf-8"); <- 만약 웹에서 해석이 안되는 타입이면 다운로드함
		resp.setContentType("application/octet-stream");  //8bit의 바이너리 데이터로 구성된 파일
		
		//전송할 파일크기 설정
		//파일 다운로드가 시작되기 전에 클라이언트가 파일의 전체 크기를 파악할 수 있도록 하며, 
		//다운로드 진행 상황을 표시할 때 유용
		resp.setContentLengthLong(filesize);
		
		//다운로드창에 보여질 파일명 지정
		//Content-Disposition : (헤더) 클라이언트가 응답 데이터를 어떻게 처리할지에 대한 정보를 제공
		//attachment : 응답 데이터를 파일 다운로드로 처리하라고 브라우저에 지시
		//filename : 파일의 이름을 지정
		resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		//2. 클라이언트에 파일내용 보내기 - 클라이언트 웹브라우저에는 전송된 데이터를 파일로 저장해줌  
		
		String path=req.getServletContext().getRealPath("/upload");
		
		//다운로드할 파일을 읽어오기 위한 파일스트림 객체 생성
		FileInputStream fis=new FileInputStream(path + File.separator + savefilename);
		
		//클라이언트에 파일을 보내기 위한 출력 스트림객체 얻어오기
		OutputStream os=resp.getOutputStream();
		
		byte[] b = new byte[1024];
		int n=0;
		while((n=fis.read(b))!=-1) {  //전송할 파일을 읽어와 b배열에 저장
			os.write(b,0,n); //b배열에 저장된 데이터를 클라이언트 웹브라우저에 보내기 - 웹브라우저가 파일로 저장해줌
		}
		
		os.close();
		fis.close();
		
	}
	
}
