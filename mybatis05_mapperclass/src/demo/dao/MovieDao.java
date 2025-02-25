package demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import members.dto.MovieDTO;
import mybatis.mapperclass.MovieMapper;
import mybatis.service.SqlSessionFactoryService;

public class MovieDao {
	private SqlSessionFactory sqlSessionFactory=SqlSessionFactoryService.getSqlSessionFactory();
	
	//try(){}묶어주면 sqlSession.close() 처리를 안해줘도 된다.
	public int insert(MovieDTO dto) {
		try (SqlSession sqlSession=sqlSessionFactory.openSession()){
			MovieMapper movieMapper=sqlSession.getMapper(MovieMapper.class);
			int n=movieMapper.insert(dto);
			sqlSession.commit();
			return n;		
		}
	}
	
	public int update(MovieDTO dto) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			MovieMapper movieMapper=sqlSession.getMapper(MovieMapper.class);
			int n=movieMapper.update(dto);
			sqlSession.commit();
			return n;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}

	public int delete(int num) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			MovieMapper movieMapper=sqlSession.getMapper(MovieMapper.class);
			int n=movieMapper.delete(num);
			sqlSession.commit();
			return n;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public MovieDTO select(int num) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			MovieMapper movieMapper=sqlSession.getMapper(MovieMapper.class);
			MovieDTO dto = movieMapper.select(num);
			return dto;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public List<MovieDTO> selectAll() {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			MovieMapper movieMapper=sqlSession.getMapper(MovieMapper.class);
			List<MovieDTO> list = movieMapper.selectAll();
			return list;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
}
