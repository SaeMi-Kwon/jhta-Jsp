package test.dto;

public class MovieRatingDTO {
	private int mnum;
	private String title;
	private String content;
	private String director;
	private MratingDTO ratingDto;  //1:1관계
	
	public MovieRatingDTO() {}

	public MovieRatingDTO(int mnum, String title, String content,
			String director, MratingDTO ratingDto) {
		this.mnum = mnum;
		this.title = title;
		this.content = content;
		this.director = director;
		this.ratingDto = ratingDto;
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
	
	
}
