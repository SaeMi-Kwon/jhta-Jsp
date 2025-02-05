package members.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import members.db.JDBCUtil;
import members.dto.MembersDto;

public class MembersDao {
	
	public int insert(MembersDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into members values(?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,dto.getNum());
			pstmt.setString(2,dto.getName());
			pstmt.setString(3,dto.getPhone());
			pstmt.setString(4,dto.getAddr());
			int n=pstmt.executeUpdate();
			
			return n;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}	
	}
	
	public int update(MembersDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update members set name=?,phone=?,addr=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getAddr());
			pstmt.setInt(4, dto.getNum());
			int n=pstmt.executeUpdate();
			
			return n;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from members where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int n=pstmt.executeUpdate();
			
			return n;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
		
	}
	
	public MembersDto findByNum(int n){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from members where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, n);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");
				
				MembersDto dto=new MembersDto(num,name,phone,addr,regdate);
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
	
	//전체 회원정보를 ArrayList에 담아서 리턴하는 메소드
	public ArrayList<MembersDto> selectAll(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		try {
			con=JDBCUtil.getCon();
			String sql="select * from members order by num";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<MembersDto> list=new ArrayList<>();
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String addr=rs.getString("addr");
				Date regdate=rs.getDate("regdate");
				
				MembersDto dto=new MembersDto(num,name,phone,addr,regdate);
				list.add(dto);
			}
			
			return list;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}	
		
	}
}
