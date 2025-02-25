package test.main;

import java.util.List;

import test.dao.MovieRatingDao;
import test.dto.CommentsDTO;
import test.dto.MovieTotalDTO;
import test.dto.MratingDTO;

public class QuizMain02 {
	public static void main(String[] args) {
		//전체 영화정보/평점/댓글을 조회해 보세요
		MovieRatingDao dao=new MovieRatingDao();
		
		List<MovieTotalDTO> list=dao.selectAll();
		
		System.out.println(list);
		
		list.forEach(m->{
			System.out.println("영화번호:"+m.getMnum());
			System.out.println("제목:"+m.getTitle());
			System.out.println("내용:"+m.getContent());
			System.out.println("감독:"+m.getDirector());
			
			MratingDTO rating=m.getRatingDto();
			System.out.println("평점:"+ rating.getRating());
			
			List<CommentsDTO> comm=m.getCommentsDto();
			for (CommentsDTO c : comm) {
				System.out.println("댓글:"+c.getComments());
			}
			
			
		});
	}
}
