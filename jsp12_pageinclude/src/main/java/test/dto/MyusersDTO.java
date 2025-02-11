package test.dto;

import java.sql.Date;

public class MyusersDTO {
	private String id;
	private String pwd;
	private String email;
	private Date regdate;
	
	public MyusersDTO() {}

	public MyusersDTO(String id, String pwd, String email, Date regdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
