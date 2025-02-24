package test.dto;

import java.util.List;

//조인된 결과를 담을 DTO
public class MovieCommentsDTO {
	private int mnum;
	private String title;
	private String content;
	private String director;
	private List<CommentsDTO> commentsList;  //영화하나당 댓글들
	
	public MovieCommentsDTO() {}

	public MovieCommentsDTO(int mnum, String title, String content, 
			String director, List<CommentsDTO> commentsList) {
		this.mnum = mnum;
		this.title = title;
		this.content = content;
		this.director = director;
		this.commentsList = commentsList;
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

	public List<CommentsDTO> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<CommentsDTO> commentsList) {
		this.commentsList = commentsList;
	}
	
	
}
