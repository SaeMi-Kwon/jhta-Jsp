package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import dto.BoardDto;

public class BoardDao {
	
	public int insert(BoardDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="insert into fileinfo values(fileinfo_seq.nextval,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getOrgfilename());
			pstmt.setString(5, dto.getSavefilename());
			pstmt.setLong(6, dto.getFilesize());
			
			int n=pstmt.executeUpdate();
			
			return n;
					
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select nvl(count(*),0) cnt from fileinfo";
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
	
	
	public ArrayList<BoardDto> list(int startRow,int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from( "
					+ "		select board.*,rownum rn from( "
					+ "			select * from fileinfo order by filenum desc"
					+ "		)board "
					+ ")where rn>=? and rn<=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			ArrayList<BoardDto> list=new ArrayList<>();
			while(rs.next()) {
				int num=rs.getInt("filenum");
				String id=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String org=rs.getString("orgfilename");
				String save=rs.getString("savefilename");
				long size=rs.getLong("filesize");
				
				BoardDto dto=new BoardDto(num,id,title,content,org,save,size);
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
	
	
	public BoardDto findByNum(int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from fileinfo where filenum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String id=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String org=rs.getString("orgfilename");
				String save=rs.getString("savefilename");
				long size=rs.getLong("filesize");
				
				BoardDto dto=new BoardDto(num,id,title,content,org,save,size);
		
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
	
	public boolean delete(int num, String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from fileinfo where filenum=? and writer=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);

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
	
	public boolean check(int num, String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from fileinfo where filenum=? and writer=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);

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
	
	public int update(BoardDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update fileinfo set title=?, content=?,"
					+ "orgfilename=?,savefilename=?,filesize=? "
					+ "where filenum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getOrgfilename());
			pstmt.setString(4, dto.getSavefilename());
			pstmt.setLong(5, dto.getFilesize());
			pstmt.setInt(6, dto.getFilenum());

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
