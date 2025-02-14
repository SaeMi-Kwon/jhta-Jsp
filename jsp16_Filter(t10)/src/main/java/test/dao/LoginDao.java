package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import test.db.ConnectionPool;

public class LoginDao {
	
	public boolean isMember(String id,String pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			con=ConnectionPool.getConn();
			String sql="select * from myusers where id=? and pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
				
			if(rs.next()) {
				return true;
			}
				
			return false;
				
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return false;
				
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}
	}

	
	
}
