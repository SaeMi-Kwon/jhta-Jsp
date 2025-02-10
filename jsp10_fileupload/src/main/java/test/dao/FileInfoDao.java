package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import test.dto.FileInfoDTO;

public class FileInfoDao {
	
	public int insert(FileInfoDTO dto) {
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
			
			return pstmt.executeUpdate();
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	public ArrayList<FileInfoDTO> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from fileinfo";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<FileInfoDTO> list = new ArrayList<>();
			while(rs.next()) {
				int num=rs.getInt("filenum");
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String org=rs.getString("orgfilename");
				String save=rs.getString("savefilename");
				long size=rs.getLong("filesize");
				
				FileInfoDTO dto = new FileInfoDTO(num,writer,title,content,org,save,size);
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
	
	public FileInfoDTO detail(int num){
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
				int filenum=rs.getInt("filenum");
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				String org=rs.getString("orgfilename");
				String save=rs.getString("savefilename");
				long size=rs.getLong("filesize");
				
				FileInfoDTO dto = new FileInfoDTO(filenum,writer,title,content,org,save,size);
				
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
	
	
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="delete from fileinfo where filenum=?";
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
	
	public int update(FileInfoDTO dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update fileinfo set title=?,content=?,orgfilename=?"
					+ ",savefilename=?,filesize=? where filenum=?";
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
