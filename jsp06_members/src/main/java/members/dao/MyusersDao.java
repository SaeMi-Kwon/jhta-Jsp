package members.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import members.db.JDBCUtil;
import members.dto.MembersDto;
import members.dto.MyusersDto;

public class MyusersDao {
	
	public int insert(MyusersDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into myusers values(?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getEmail());

			int n=pstmt.executeUpdate();
			
			return n;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
		
	public int findById(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			con=JDBCUtil.getCon();
			String sql="select * from myusers where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
				
			if(rs.next()) {
				return 1;
			}
				
			return 0;
				
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
				
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
		
	}
		
	public boolean isAdmin(String id,String pwd) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			con=JDBCUtil.getCon();
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
			JDBCUtil.close(con, pstmt, rs);
		}
		
	}


}
