package test.main;

import java.util.List;

import test.dao.DeptDao;
import test.dto.DeptEmpDTO;
import test.dto.EmpDTO;

/*
 * dept테이블과 emp테이블과 연동해서
 * 부서번호,부서이름,근무사원번호,이름,직업을 조회해 보세요.
 * 
 * 매퍼파일(xxxMaper.xml)/DTO/DAO/main메소드
 */
public class QuizMain {
	public static void main(String[] args) {
		DeptDao dao=new DeptDao();
		
		List<DeptEmpDTO> list=dao.selectEmpList();
		for(DeptEmpDTO d:list) {
			System.out.println("부서번호:" + d.getDeptno());
			System.out.println("부서명:" + d.getDname());
			System.out.println("--------------------------");
			List<EmpDTO> eList=d.getEmpList();
			for(EmpDTO e:eList) {
				System.out.println("사원번호:" + e.getEmpno());
				System.out.println("사원명:" + e.getEname());
				System.out.println("직업:" + e.getJob());
				
			}
			System.out.println("===========================");
			System.out.println();
		}
	}
}
