package test.dto;

public class BItemDTO {
	private int inum;
	private String itemname;
	private String descrip;
	private long price;
	
	public BItemDTO() {}

	public BItemDTO(int inum, String itemname, String descrip, long price) {
		this.inum = inum;
		this.itemname = itemname;
		this.descrip = descrip;
		this.price = price;
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
	
	
}
