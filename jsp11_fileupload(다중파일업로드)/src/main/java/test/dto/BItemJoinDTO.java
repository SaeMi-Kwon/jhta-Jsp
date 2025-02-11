package test.dto;

import java.util.ArrayList;

public class BItemJoinDTO {
	private int inum;
	private String itemname;
	private String descrip;
	private long price;
	
	private ArrayList<ItemFilesDTO> files;
	
	public BItemJoinDTO() {}

	public BItemJoinDTO(int inum, String itemname, String descrip, long price, ArrayList<ItemFilesDTO> files) {
		this.inum = inum;
		this.itemname = itemname;
		this.descrip = descrip;
		this.price = price;
		this.files = files;
	}

	public int getInum() {
		return inum;
	}

	public void setInum(int inum) {
		this.inum = inum;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public ArrayList<ItemFilesDTO> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<ItemFilesDTO> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "BItemJoinDTO [inum=" + inum + ", itemname=" + itemname + ", descrip=" + descrip + ", price=" + price
				+ ", files=" + files + "]";
	}
	
	
	
}
