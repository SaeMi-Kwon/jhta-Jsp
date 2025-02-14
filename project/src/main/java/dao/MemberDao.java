package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JDBCUtil;
import dto.MemberDto;

public class MemberDao {
	
	public int insert(MemberDto dto) {
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
	
	//아이디중복체크
	public boolean findById(String id) {
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
	
	//로그인
	public boolean isMember(String id,String pwd) {
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
	
	//회원조회(id)
	public MemberDto select(String id) {
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
				String pwd=rs.getString("pwd");
				String email=rs.getString("email");
				Date regdate=rs.getDate("regdate");
				
				MemberDto dto=new MemberDto(id,pwd,email,regdate);
				
				return dto;
			}
				
			return null;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	//회원정보 수정
	public int update(MemberDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update myusers set pwd=?,email=? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getPwd());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getId());
			int n=pstmt.executeUpdate();
			
			return n;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	
	//회원삭제
	public boolean delete(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from myusers where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			int n=pstmt.executeUpdate();
			
			if(n>0) {
				return true;
			}
			
			return false;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return false;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
}
