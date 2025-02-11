package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.JDBCUtil;

public class MyusersDao {
	
	private static MyusersDao instance=new MyusersDao();
	
	private MyusersDao() {}
	
	public static MyusersDao getInstance() {
		return instance;
	}

	public int check(String id,String pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from myusers where id=? and pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, pwd);
			return pstmt.executeUpdate();
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
		
		
	}
}
