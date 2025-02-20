package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import test.dto.MovieDTO;

public class MovieDao {
	
	public MovieDTO select(int mnum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from movie where mnum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, mnum);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String title=rs.getString("title");
				String content=rs.getString("content");
				String director=rs.getString("director");
				MovieDTO vo=new MovieDTO(mnum,title,content,director);
				return vo;

			}
			return null;
					
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return null;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<MovieDTO> mList() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from movie";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<MovieDTO> list=new ArrayList<>();
			while(rs.next()) {
				int mnum=rs.getInt("mnum");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String director=rs.getString("director");
				MovieDTO vo=new MovieDTO(mnum,title,content,director);
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
	
}
