package test.main;

import java.util.Scanner;

import test.dao.MovieRatingDao;
import test.dto.MovieRatingDTO;
import test.dto.MratingDTO;

public class QuizMain01 {
	public static void main(String[] args) {
		//영화번호를 입력받아 해당 영화정보와 평점,관계수를 출력해 보세요.
		Scanner sc=new Scanner(System.in);
		System.out.print("영화번호를 입력해주세요:");
		int num=sc.nextInt();
		
		MovieRatingDao dao=new MovieRatingDao();
		
		MovieRatingDTO dto=dao.select(num);
		
		if(dto!=null) {
			System.out.println("영화번호:"+dto.getMnum());
			System.out.println("제목:"+dto.getTitle());
			System.out.println("내용:"+dto.getContent());
			System.out.println("감독:"+dto.getDirector());
			MratingDTO rating=dto.getRatingDto();
			System.out.println("평점:"+rating.getRating());
			System.out.println("관객수:"+rating.getAudience());
			
		}else {
			System.out.println("조회된 영화가 없어요");
		}
		
		
	}
}
