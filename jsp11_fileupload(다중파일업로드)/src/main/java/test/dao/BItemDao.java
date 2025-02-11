package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import test.dto.BItemDTO;
import test.dto.BItemJoinDTO;
import test.dto.ItemFilesDTO;

public class BItemDao {
	
	//싱글톤
	private static BItemDao instance=new BItemDao();
	
	private BItemDao() {}
	
	public static BItemDao getInstance() {
		return instance;
	}
	
	public int insert(BItemDTO vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		ResultSet rs=null;
		
		try {
			String sql="insert into bitem values(item_seq.nextval,?,?,?)";
			con=JDBCUtil.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getItemname());
			pstmt.setString(2, vo.getDescrip());
			pstmt.setLong(3, vo.getPrice());
			
			pstmt.executeUpdate();
			
			//등록된 제품번호 얻어오기(현재 발생된 시퀀스값)
			pstmt1=con.prepareStatement("select item_seq.currval from dual");
			rs=pstmt1.executeQuery();
			rs.next();
			int itemnum=rs.getInt(1); //첫번째 컬럼값 얻어오기
			return itemnum;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt1);
			JDBCUtil.close(con, pstmt, null);
		}
	}
	
	public ArrayList<BItemDTO> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from bitem";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			ArrayList<BItemDTO> list=new ArrayList<>();
			while(rs.next()) {
				int inum=rs.getInt("inum");
				String itemname=rs.getString("itemname");
				String descrip=rs.getString("descrip");
				long price=rs.getLong("price");
				
				BItemDTO dto=new BItemDTO(inum,itemname,descrip,price);
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
	
	public BItemJoinDTO detail(int inum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from bitem where inum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, inum);
			rs=pstmt.executeQuery();
			
			BItemJoinDTO dto=new BItemJoinDTO();
			if(rs.next()) {
				String itemname=rs.getString("itemname");
				String descrip=rs.getString("descrip");
				long price=rs.getLong("price");
				
				String sql1="select * from itemfiles where inum=?";
				ArrayList<ItemFilesDTO> files=new ArrayList<>();
				
				PreparedStatement pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1, inum);
				ResultSet rs1=pstmt1.executeQuery();
				
				while(rs1.next()) {
					int fnum=rs1.getInt("fnum");
					String orgfilesname=rs1.getString("orgfilename");
					String savefilesname=rs1.getString("savefilename");
					long filesize=rs1.getLong("filesize");
					
					ItemFilesDTO filedto=new ItemFilesDTO(fnum,inum,orgfilesname,savefilesname,filesize);
					files.add(filedto);
				}
				
				dto.setInum(inum);
				dto.setItemname(itemname);
				dto.setPrice(price);
				dto.setDescrip(descrip);
				dto.setFiles(files);
				
				rs1.close();
				pstmt1.close();
				
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
	
}
