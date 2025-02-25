package test.dto;

public class MratingDTO {
	private int num;
	private int mnum;
	private double rating;
	private int audience;
	
	public MratingDTO() {}

	public MratingDTO(int num, int mnum, double rating, int audience) {
		this.num = num;
		this.mnum = mnum;
		this.rating = rating;
		this.audience = audience;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getAudience() {
		return audience;
	}

	public void setAudience(int audience) {
		this.audience = audience;
	}

	@Override
	public String toString() {
		return "MratingDTO [num=" + num + ", mnum=" + mnum + ", rating=" + rating + ", audience=" + audience + "]";
	}
	
	
}
