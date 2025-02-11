package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db.JDBCUtil;
import test.dto.ItemFilesDTO;

public class ItemFilesDao {
	
	//싱글톤
	private static ItemFilesDao instance=new ItemFilesDao();
	
	private ItemFilesDao() {}
	
	public static ItemFilesDao getInstance() {
		return instance;
	}
	
	public int insert(ItemFilesDTO dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			String sql="insert into itemfiles values(itemfiles_seq.nextval,?,?,?,?)";
			con=JDBCUtil.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getInum());
			pstmt.setString(2, dto.getOrgfilename());
			pstmt.setString(3, dto.getSavefilename());
			pstmt.setLong(4, dto.getFilesize());
			return pstmt.executeUpdate();
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, null);
		}
	}
	

}
