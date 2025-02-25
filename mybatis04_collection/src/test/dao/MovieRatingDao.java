package test.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.service.SqlSessionFactoryService;
import test.dto.MovieRatingDTO;
import test.dto.MovieTotalDTO;

public class MovieRatingDao {
	private SqlSessionFactory sqlSessionFactory=SqlSessionFactoryService.getSqlSessionFactory();
	private final String NAMESPACE="mybatis.mapper.MovieRatingMapper";
	
	public List<MovieRatingDTO> selectList(){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			return sqlSession.selectList(NAMESPACE + ".movieRating");
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public MovieRatingDTO select(int mnum){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			return sqlSession.selectOne(NAMESPACE + ".movieInfo",mnum);
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public List<MovieTotalDTO> selectAll(){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			return sqlSession.selectList(NAMESPACE+".movieTotal");
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
}
