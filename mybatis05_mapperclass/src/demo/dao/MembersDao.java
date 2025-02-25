package demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import members.dto.MembersDto;
import mybatis.mapperclass.MembersMapper;
import mybatis.service.SqlSessionFactoryService;

public class MembersDao {
	private SqlSessionFactory sqlSessionFactory=SqlSessionFactoryService.getSqlSessionFactory();
	
	public int insert(MembersDto dto) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			//Mapper클래스 얻어오기
			MembersMapper membersMapper=sqlSession.getMapper(MembersMapper.class);
			int n=membersMapper.insert(dto);
			sqlSession.commit();
			return n;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	//delete/update/select/selectAll메소드 사용하는 메소드만들기
	
	public int delete(int num) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			MembersMapper membersMapper=sqlSession.getMapper(MembersMapper.class);
			int n=membersMapper.delete(num);
			sqlSession.commit();
			return n;
			
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public int update(MembersDto dto) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			MembersMapper membersMapper=sqlSession.getMapper(MembersMapper.class);
			int n=membersMapper.update(dto);
			sqlSession.commit();
			return n;
		
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public MembersDto getInfo(int num) {
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			MembersMapper membersMapper=sqlSession.getMapper(MembersMapper.class);
			MembersDto dto =membersMapper.select(num);
			return dto;
		
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
	public List<MembersDto> list(){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			MembersMapper membersMapper=sqlSession.getMapper(MembersMapper.class);
			List<MembersDto> list =membersMapper.selectAll();
			return list;
		
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
}
