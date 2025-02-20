package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import test.dto.CommentsDTO;

public class CommentsDao {

	public int insert(CommentsDTO vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into comments values(comments_seq.nextval,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getMnum());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getComments());
			int n=pstmt.executeUpdate();
			
			return n;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	public int getCount(int mnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select nvl(count(*),0)cnt from comments where mnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
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
	
	public ArrayList<CommentsDTO> cList(int mnum,int startRow,int endRow) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from("
					+ "    select comm.*,rownum rn from("
					+ "        select * from comments where mnum=? order by num desc"
					+ "    )comm "
					+ ") "
					+ "where rn>=? and rn<=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs=pstmt.executeQuery();
			
			ArrayList<CommentsDTO> list=new ArrayList<>();
			while(rs.next()) {
				int num=rs.getInt("num");
				String id=rs.getString("id");
				String comments=rs.getString("comments");
				
				CommentsDTO vo=new CommentsDTO(num,mnum,id,comments);
				list.add(vo);
			}
			return list;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from comments where num=?";
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
	
	
}
