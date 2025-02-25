package test.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import members.dao.MembersDao;
import members.dto.MembersDto;

//테스트 클래스 만들기 - public / 디폴트 생성자가 있어야 함
public class DaoTestClass {
	
	//테스트 메소드 - 리턴타입이 void이고 매개변수는 없다
	@Test
	public void mebersDaoInsert() {
		MembersDao dao=new MembersDao();
		int n=dao.insert(new MembersDto(6,"김테스트","011-8877-2244","미국",null));
		assertEquals(n, 1);  //n값이 1과 같은지 검사
		
	}
	
	@Test
	public void delete() {
		MembersDao dao=new MembersDao();
		int n=dao.delete(9);
		assertEquals(n, 1);
	}
	
	@Test
	public void select() {
		MembersDao dao=new MembersDao();
		MembersDto dto=dao.findByNum(1);
		assertNotNull(dto);  //dto가 null인지 검사
	}
	
	

}
