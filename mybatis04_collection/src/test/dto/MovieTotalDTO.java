package test.dto;

import java.util.List;

public class MovieTotalDTO {
	private int mnum;
	private String title;
	private String content;
	private String director;
	
	private MratingDTO ratingDto;  //1:1(평점)
	private List<CommentsDTO> commentsDto; //1:N(댓글)
	
	public MovieTotalDTO() {}

	public MovieTotalDTO(int mnum, String title, String content, 
			String director, MratingDTO ratingDto,
			List<CommentsDTO> commentsDto) {
		this.mnum = mnum;
		this.title = title;
		this.content = content;
		this.director = director;
		this.ratingDto = ratingDto;
		this.commentsDto = commentsDto;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public MratingDTO getRatingDto() {
		return ratingDto;
	}

	public void setRatingDto(MratingDTO ratingDto) {
		this.ratingDto = ratingDto;
	}

	public List<CommentsDTO> getCommentsDto() {
		return commentsDto;
	}

	public void setCommentsDto(List<CommentsDTO> commentsDto) {
		this.commentsDto = commentsDto;
	}

	@Override
	public String toString() {
		return "MovieTotalDTO [mnum=" + mnum + ", title=" + title + ", content=" + content + ", director=" + director
				+ ", ratingDto=" + ratingDto + ", commentsDto=" + commentsDto + "]";
	}

	
}
