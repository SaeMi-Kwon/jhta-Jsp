package demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import demo.dao.MovieDao;
import members.dto.MovieDTO;

public class MovieTestClass {

	@Test
	public void MovieDaoInsert() {
		MovieDao dao=new MovieDao();
		int n=dao.insert(new MovieDTO(0,"JUnit","단위테스트","박감독"));
		assertEquals(n, 1);
	}
	
	@Test
	public void MovieDaoUpdate() {
		MovieDao dao=new MovieDao();
		int n=dao.update(new MovieDTO(21,"JUnit22","단위테스트22","홍감독"));
		assertEquals(n, 1);
	}
	
	@Test
	public void MovieDaoDelete() {
		MovieDao dao=new MovieDao();
		int n=dao.delete(42);
		assertEquals(n, 1);
	}
	
	@Test
	public void MovieSelect() {
		MovieDao dao=new MovieDao();
		MovieDTO dto=dao.select(1);
		assertNotNull(dto);
	}
	
	@Test
	public void MovieSelectAll() {
		MovieDao dao=new MovieDao();
		List<MovieDTO> list=dao.selectAll();
		int n=list.size();
		assertEquals(n, 2);   //전체데이터 갯수로 비교하기 
	}
	
}
