package test.dto;

public class MovieDTO {
	private int mnum;
	private String title;
	private String content;
	private String director;
	
	public MovieDTO() {}

	public MovieDTO(int mnum, String title, String content, String director) {
		this.mnum = mnum;
		this.title = title;
		this.content = content;
		this.director = director;
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
	
	
}
