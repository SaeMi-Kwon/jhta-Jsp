package test.dto;

public class ItemFilesDTO {
	private int fnum;
	private int inum;
	private String orgfilename;
	private String savefilename;
	private long filesize;
	
	public ItemFilesDTO() {}

	public ItemFilesDTO(int fnum, int inum, String orgfilename,
			String savefilename, long filesize) {
		this.fnum = fnum;
		this.inum = inum;
		this.orgfilename = orgfilename;
		this.savefilename = savefilename;
		this.filesize = filesize;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public int getInum() {
		return inum;
	}

	public void setInum(int inum) {
		this.inum = inum;
	}

	public String getOrgfilename() {
		return orgfilename;
	}

	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

	public String getSavefilename() {
		return savefilename;
	}

	public void setSavefilename(String savefilename) {
		this.savefilename = savefilename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	
	
}
