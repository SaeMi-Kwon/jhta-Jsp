package test.dto;

public class BoardDto {
	private int num;
	private String writer;
	private String title;
	private String content;
	private int ref;
	private int lev;
	private int step;
	
	public BoardDto() {}

	public BoardDto(int num, String writer, String title, String content, int ref, int lev, int step) {
		this.num = num;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.ref = ref;
		this.lev = lev;
		this.step = step;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	
	@Override
	public String toString() {
		return "BoardDto [num=" + num + ", writer=" + writer + ", title=" + title + ", content=" + content + ", ref="
				+ ref + ", lev=" + lev + ", step=" + step + "]";
	}
	
	
}
