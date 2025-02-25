package test.main;

import test.dao.MovieRatingDao;
import test.dto.MratingDTO;

public class TestMainRating {
	public static void main(String[] args) {
		MovieRatingDao dao = new MovieRatingDao();
		dao.selectList().forEach(m->{
			System.out.println("영화번호:" + m.getMnum());
			System.out.println("제목:" + m.getTitle());
			System.out.println("내용:" + m.getContent());
			System.out.println("감독:" + m.getDirector());
			
			MratingDTO ratingDTO=m.getRatingDto();  //평점정보
			System.out.println("평점번호:" + ratingDTO.getNum());
			System.out.println("평점:" + ratingDTO.getRating());
			System.out.println("관객수:" + ratingDTO.getAudience());
			System.out.println("----------------------------------");
		});
		
	}
	
}
