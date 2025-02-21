package test.main;

import java.io.IOException;
import java.io.InputStream;

import members.dto.MembersDto;
import org.apache.ibatis.session.*;
import org.apache.ibatis.io.Resources;


public class TestMain {
	public static void main(String[] args) {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			
			//수행할 sql구문을 호출하기 위한 SqlSession객체 얻어오기
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//insert
//			MembersDto dto=new MembersDto(100,"바티스","0101112222","미국",null);
//			//sqlSession.insert("mybatis.mapper.MembersMapper.insert",dto); --> id 중복방지하기위해 namespace까지 사용
//			int n=sqlSession.insert("insert",dto);   //sqlSession.insert(id값,파라미터넘김)
//			sqlSession.commit();  //dml작업후에는 커밋한다  <- 자동커밋X 아니므로
//			System.out.println( n + "명의 회원 등록");
			
			//delete
//			int n1=sqlSession.delete("delete",100);
//			System.out.println(n1 + "명의 회원삭제");
//			sqlSession.commit();
			
			//update
			MembersDto dto1=new MembersDto(41,"mybatis","010-888-8888","파리",null);
			int n2=sqlSession.update("update", dto1);
			sqlSession.commit();
			System.out.println(n2 + "명의 회원수정");
			
			//sqlsession종료 - db연결해제
			sqlSession.close();
			
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}
