package mybatis_quiz;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.*;

import members.dto.MyusersDto;

import org.apache.ibatis.io.Resources;

public class TestMain {
	public static void main(String[] args) {
		
		try {
			String resource = "db/config/DB-Config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession= sqlSessionFactory.openSession();
			
			//insert
//			MyusersDto dto=new MyusersDto("ttest","5555","ttest@ttest",null);
//			int n=sqlSession.insert("userInsert", dto);
//			sqlSession.commit();
//			System.out.println(n + "명의 회원 추가");
			
			//delete
//			int n1=sqlSession.delete("userDelete", "test");
//			sqlSession.commit();
//			System.out.println(n1 + "명의 회원 삭제" );
			
			//update
//			MyusersDto dto1=new MyusersDto("ttest","9999","tt@tt",null);
//			int n2=sqlSession.update("userUpdate", dto1);
//			sqlSession.commit();
//			System.out.println(n2 + "명의 회원 수정");

			//select(조건)
//			MyusersDto dto=sqlSession.selectOne("idInfo", "ttest");
//			
//			if(dto==null) {
//				System.out.println("존재하는 아이디가 없습니다");
//			}else {
//				System.out.println("아이디:" + dto.getId());
//				System.out.println("비밀번호:" + dto.getPwd());
//				System.out.println("이메일:" + dto.getEmail());
//				System.out.println("등록일:" + dto.getRegdate());
//			}
			
			//select(전체)
			List<MyusersDto> list=sqlSession.selectList("showInfo");
			for(MyusersDto ul:list) {
				System.out.println("아이디:" + ul.getId());
				System.out.println("비밀번호:" + ul.getPwd());
				System.out.println("이메일:" + ul.getEmail());
				System.out.println("등록일:" + ul.getRegdate());
				System.out.println();
			}
				
			sqlSession.close();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
