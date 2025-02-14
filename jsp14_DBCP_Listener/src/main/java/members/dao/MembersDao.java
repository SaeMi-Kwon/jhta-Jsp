package members.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import members.dto.MembersDto;
import test.db.ConnectionPool;

public class MembersDao {
	private ConnectionPool cp;
	public MembersDao() {}
	public MembersDao(ConnectionPool cp) {
		this.cp=cp;
	}
	
	//전체 회원정보를 ArrayList에 담아서 리턴하는 메소드
	public ArrayList<MembersDto> selectAll(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	
		try {
			con=cp.getConnection();
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
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) cp.closeConnection(con);  //컨넥션 풀에 컨넥션 반환
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}	
	}
	
	public int insert(MembersDto dto){
		Connection con=null;
		PreparedStatement pstmt=null;
	
		try {
			con=cp.getConnection();
			String sql="insert into members values(?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddr());
	
			return pstmt.executeUpdate();
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) cp.closeConnection(con);  //컨넥션 풀에 컨넥션 반환
			}catch(SQLException s) {
				System.out.println(s.getMessage());
			}
		}	
	}
	
	
}
