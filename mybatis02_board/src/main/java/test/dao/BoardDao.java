package test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.service.SqlSessionFactoryService;
import test.dto.Board;

public class BoardDao {

	private SqlSessionFactory sqlSessionFactory=null;
	private final String NAMESPACE="mybatis.mapper.BoardMapper";
	
	public BoardDao() {  //sqlSessionFactory 필드를 초기화
		sqlSessionFactory=SqlSessionFactoryService.getSqlSessionFactory();
		
	}
	
	public int insert(Board dto) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			int n=sqlSession.insert(NAMESPACE + ".insert", dto);
			sqlSession.commit();
			return n;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	
	public List<Board> selectList(HashMap<String,String> map){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			List<Board> list=sqlSession.selectList(NAMESPACE+".selectList",map);
			return  list;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public int delete(int num) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			int n=sqlSession.delete(NAMESPACE + ".delete", num);
			sqlSession.commit();
			return n;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	
	public Board getInfo(int num){
		SqlSession sqlSession=null;
			
		try {
			sqlSession=sqlSessionFactory.openSession();
			Board dto=sqlSession.selectOne(NAMESPACE + ".getInfo", num);
			return  dto;
				
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public int update(Board dto) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			int n=sqlSession.delete(NAMESPACE + ".update", dto);
			sqlSession.commit();
			return n;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public List<Board> searchList(HashMap<String,String> map){
		SqlSession sqlSession=null;
		try {
			sqlSession=sqlSessionFactory.openSession();
			List<Board> list=sqlSession.selectList(NAMESPACE + ".searchList",map);
			return list;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
		
	}
}
