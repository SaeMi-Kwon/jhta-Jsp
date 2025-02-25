package demo.main;

import java.util.List;

import demo.dao.MembersDao;
import members.dto.MembersDto;

public class DemoMain {
	public static void main(String[] args) {
		MembersDao dao=new MembersDao();
		
		//insert
//		int n=dao.insert(new MembersDto(90,"demo","010-1245-1230","seoul",null));
//		System.out.println(n + "명의 회원이 등록됨");
		
		//delete
//		int n1=dao.delete(90);
//		System.out.println(n1 +"명의 회원이 삭제됨");
		
		//update
//		int n2=dao.update(new MembersDto(8,"demotest","010-321-9876","busan",null));
//		System.out.println(n2 + "명의 회원 수정됨");
		
		//select
//		MembersDto dto=dao.getInfo(2);
//		if(dto!=null) {
//			System.out.println("번호: "+ dto.getNum());
//			System.out.println("이름: "+ dto.getName());
//			System.out.println("전화번호: "+ dto.getPhone());
//			System.out.println("주소: "+ dto.getAddr());
//			System.out.println("가입일: "+ dto.getRegdate());		
//		}
		
		//selectAll
		List<MembersDto> list=dao.list();
		list.forEach(m->{
			System.out.println("번호: " + m.getNum());
			System.out.println("이름: " + m.getName());
			System.out.println("전화번호: " + m.getPhone());
			System.out.println("주소: " + m.getAddr());
			System.out.println("가입일: " + m.getRegdate());
			System.out.println();
		});
	}
}
