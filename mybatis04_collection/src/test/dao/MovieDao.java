package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.service.SqlSessionFactoryService;
import test.dto.MovieCommentsDTO;
import test.dto.MovieDTO;

public class MovieDao {
	private SqlSessionFactory sqlSessionFactory=SqlSessionFactoryService.getSqlSessionFactory();
	private final String NAMESPACE="mybatis.mapper.MovieMapper";
	
	public List<MovieDTO> selectList(){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			return sqlSession.selectList(NAMESPACE + ".select");
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public List<MovieCommentsDTO> selectCommentsList(){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			return sqlSession.selectList(NAMESPACE + ".movieComments");
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}

}
