package test.dto;

import java.util.List;

public class DeptEmpDTO {
	private int deptno;
	private String dname;
	private List<EmpDTO> empList;
	
	public DeptEmpDTO() {}

	public DeptEmpDTO(int deptno, String dname, List<EmpDTO> empList) {
		this.deptno = deptno;
		this.dname = dname;
		this.empList = empList;
	}


	public int getDeptno() {
		return deptno;
	}


	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public List<EmpDTO> getEmpList() {
		return empList;
	}


	public void setEmpList(List<EmpDTO> empList) {
		this.empList = empList;
	}
	
	
}
