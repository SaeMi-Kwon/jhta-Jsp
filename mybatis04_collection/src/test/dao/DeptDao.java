package test.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.service.SqlSessionFactoryService;
import test.dto.DeptEmpDTO;

public class DeptDao {
	private SqlSessionFactory sqlSessionFactory=SqlSessionFactoryService.getSqlSessionFactory();
	private final String NAMESPACE="mybatis.mapper.DeptEmpMapper";
	
	public List<DeptEmpDTO> selectEmpList(){
		SqlSession sqlSession=null;
		
		try {
			sqlSession=sqlSessionFactory.openSession();
			return sqlSession.selectList(NAMESPACE + ".deptEmp");
		
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}
	}
	
}
