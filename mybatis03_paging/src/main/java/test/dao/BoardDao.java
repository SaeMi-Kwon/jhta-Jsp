package test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.service.SqlSessionFactoryService;
import test.dto.Board;

public class BoardDao {
	private final String NAMESPACE="mybatis.mapper.MyBoardMapper";
	
	private SqlSessionFactory sqlSessionFactory=SqlSessionFactoryService.getSqlSessionFactory();
	
	//list, getCount 호출하는 메소드 만들기
	public List<Board> list(HashMap<String,Object> map){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			return sqlSession.selectList(NAMESPACE + ".list", map);
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public int getCount(HashMap<String,Object> map) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			int n=sqlSession.selectOne(NAMESPACE + ".getCount",map);
			return n;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public List<Board> searchList(HashMap<String,String> map){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			List<Board> list = sqlSession.selectList(NAMESPACE + ".search",map);
			return list;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}

}
