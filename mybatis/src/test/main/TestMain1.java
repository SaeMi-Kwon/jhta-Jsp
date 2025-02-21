package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.*;

import members.dto.MembersDto;

import org.apache.ibatis.io.Resources;

public class TestMain1 {
	public static void main(String[] args) {
		String resource="mybatis/config/mybatis-config.xml";
		
		try {
			InputStream is=Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory=
					new SqlSessionFactoryBuilder().build(is);
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			//조회되는 데이터가 0개아니면 1개인경우는 selectOne메소드로 조회
			MembersDto dto=sqlSession.selectOne("getinfo", 1);
			if(dto==null) {  //데이터가 없으면 null값을 반환한다
				System.out.println("조회된 회원이 없어요");
			}else {
				System.out.println("회원번호:" + dto.getNum());
				System.out.println("회원이름:" + dto.getName());
				System.out.println("전화번호:" + dto.getPhone());
				System.out.println("주소:" + dto.getAddr());
				System.out.println("가입일:" + dto.getRegdate());
			}
			
			//select로 조회된 결과가 2개 이상이면 selectList메소드를 사용한다.
			List<MembersDto> list=sqlSession.selectList("selectAll");
			System.out.println("<< 전체 회원조회 >>");
			for(MembersDto dto1:list) {
				System.out.println("회원번호:" + dto1.getNum());
				System.out.println("회원이름:" + dto1.getName());
				System.out.println("전화번호:" + dto1.getPhone());
				System.out.println("주소:" + dto1.getAddr());
				System.out.println("가입일:" + dto1.getRegdate());
				System.out.println();
			}
			
			sqlSession.close();
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}
