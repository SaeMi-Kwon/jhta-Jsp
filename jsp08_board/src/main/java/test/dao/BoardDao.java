package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import test.dto.Board;

public class BoardDao {
	
	public int insert(Board dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into myboard values(myboard_seq.nextval,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			int n=pstmt.executeUpdate();
		
			return n;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	//전체 글의 갯수 반환 메소드
	public int getCount(String field,String keyword) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select nvl(count(*),0) cnt from myboard";
			
			if(field!=null && !field.equals("")) {
				sql = sql + " where " + field + " like '%"+ keyword + "%'";
			}
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			return -1;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	
	public ArrayList<Board> list(int startRow,int endRow,String field,String keyword){
		String sql="";  //초기화
		
		if(field!=null && !field.equals("")) { //검색조건이 있는 경우
			sql="select * from( "
					+ "   select board.*,rownum rn from( "
					+ "		select * from myboard  where " + field 
					+		" like '%"+ keyword + "%' order by num desc "
					+ "	  )board "
					+ ") where rn>=? and rn<=?";
			
		}else {  //검색조건이 없는 경우
			sql="select * from( "
					+ "   select board.*,rownum rn from( "
					+ "		select * from myboard order by num desc "
					+ "	  )board "
					+ ") where rn>=? and rn<=?";
		}
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			con=JDBCUtil.getCon();

			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			ArrayList<Board> list = new ArrayList<Board>();
			while(rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title =rs.getString("title");
				String content =rs.getString("content");
				Date regdate =rs.getDate("regdate");
				
				Board bto=new Board(num,writer,title,content,regdate);
				
				list.add(bto);
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
