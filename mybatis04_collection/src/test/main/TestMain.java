package test.main;

import java.util.List;

import test.dao.MovieDao;
import test.dto.CommentsDTO;
import test.dto.MovieCommentsDTO;

public class TestMain {
	public static void main(String[] args) {
		MovieDao dao=new MovieDao();
//		List<MovieDTO> list=dao.selectList();
//		list.forEach(m->{
//			System.out.println("영화번호:" + m.getMnum());
//			System.out.println("제목:" + m.getTitle());
//			System.out.println("내용:" + m.getContent());
//			System.out.println("감독:" + m.getDirector());
//			System.out.println();
//		});
//		
	
		List<MovieCommentsDTO> list=dao.selectCommentsList();
		for(MovieCommentsDTO m:list) {
			System.out.println("영화번호:" + m.getMnum());
			System.out.println("제목:" + m.getTitle());
			System.out.println("내용:" + m.getContent());
			System.out.println("감독:" + m.getDirector());
			System.out.println("---------------------------");
			List<CommentsDTO> cList=m.getCommentsList();
			for(CommentsDTO c:cList) {
				System.out.println("댓글번호:" + c.getNum());
				System.out.println("아이디:" + c.getId());
				System.out.println("내용:" + c.getComments());
			}
			System.out.println();
		}
		
		
	}
}
