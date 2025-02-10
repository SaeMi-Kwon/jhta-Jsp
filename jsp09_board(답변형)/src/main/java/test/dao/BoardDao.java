package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.JDBCUtil;
import test.dto.BoardDto;

/*
 * [ 싱글톤패턴 ]
 * - 객체가 하나만 생성되게 하는 기법. 객체를 공유해서 사용한다.
 * - 만드는 방법
 * 	1. 객체자신을 static멤버로 생성한다.
 * 	2. 생성자를 private로 만들어 외부에서는 생성하지 못하도록 한다.
 * 	3. 1에서 생성된 객체를 리턴하는 static메소드를 만든다.
 */

public class BoardDao {
	//1. 객체자신을 static멤버로 생성한다.
	private static BoardDao instance=new BoardDao();  //instance -> 변수명
	
	//2. 생성자를 private로 만들어 외부에서는 생성하지 못하도록 한다.
	private BoardDao() {}
	
	//3. 1에서 생성된 객체를 리턴하는 static메소드를 만든다.
	public static BoardDao getInstance() {
		return instance;
	}
	
	//가장 큰 글번호 구하기
	public int getMaxNum() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select NVL(max(num),0) MAXNUM from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			rs.next();
			int maxnum=rs.getInt(1);
			return maxnum;
			
		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(con, pstmt, rs);
		}
	}
	
	public int insert(BoardDto dto) {
		Connection con=null;
		PreparedStatement pstmt1=null;  //db에 저장하는용
		PreparedStatement pstmt2=null;	//업데이트용(step)
		
		try {
			con=JDBCUtil.getCon();
			
			//ref,lev,step 계산해줘야 한다.
			int boardNum=getMaxNum()+1;  //등록될 글번호 구하기
			
			//이미 등록되어있는 부모(자식) 값 가져오기
			int num=dto.getNum();   
			int ref=dto.getRef();
			int lev=dto.getLev();
			int step=dto.getStep();
			
			if(num==0) {  //새글인 경우
				ref=boardNum;
				
			}else {  //답글인 경우
				//같은 그룹의 답글중에서 나보다 step이 큰 글들의 step을 1씩 증가한다 
				//-> 최신 답글을 위로 올리기 (같은 그룹중에서 나보다 step이 클 경우 기존 step에 1씩 올린다.) 
				String sql1="update board set step=step+1 where ref=? and step>?";
				pstmt2=con.prepareStatement(sql1);
				pstmt2.setInt(1, ref);
				pstmt2.setInt(2, step);
				pstmt2.executeUpdate();
				
				lev += 1;
				step += 1;
			}
			
			//글 추가하기
			String sql="insert into board values(?,?,?,?,?,?,?)";
			pstmt1=con.prepareStatement(sql);
			pstmt1.setInt(1, boardNum);
			pstmt1.setString(2,dto.getWriter());
			pstmt1.setString(3,dto.getTitle());
			pstmt1.setString(4,dto.getContent());
			pstmt1.setInt(5, ref);
			pstmt1.setInt(6, lev);
			pstmt1.setInt(7, step);
			
			return pstmt1.executeUpdate();

		}catch(SQLException s) {
			System.out.println(s.getMessage());
			return -1;
			
		}finally {
			JDBCUtil.close(pstmt1);
			JDBCUtil.close(pstmt2);
			JDBCUtil.close(con);
		}
	}
	
	//전체 글의 갯수 구하기
	public int getCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			con=JDBCUtil.getCon();
			String sql="select NVL(count(num),0) cnt from board";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int cnt=rs.getInt(1);
				
			return cnt;
				
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			return -1;
				
		}finally {
			JDBCUtil.close(con, pstmt, rs);
			
		}
		
	}
	
	public ArrayList<BoardDto> list(int startRow,int endRow){
		String sql="select * from("
				+ "    select b.*,rownum rn from("
				+ "        select * from board"
				+ "        order by ref desc,step asc"
				+ "    )b "
				+ ")where rn>=? and rn<=?";
			
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getCon();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
				
			ArrayList<BoardDto> list=new ArrayList<>();
			while(rs.next()) {
				int num=rs.getInt("num");
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
					
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");
					
				BoardDto vo=new BoardDto(num,writer,title,content,ref,lev,step);
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
	
	
	public BoardDto findByNum(int num){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="select * from board where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
				
			if(rs.next()) {
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");

				BoardDto vo=new BoardDto(num,writer,title,content,ref,lev,step);
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
	
	//최신글 5개 얻어오기(답변제외)
	public ArrayList<BoardDto> showFive(int startRow,int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=JDBCUtil.getCon();
			String sql="select * from("
					+ "    select b.*,rownum rn from("
					+ "        select * from board"
					+ "        where lev=0 and step=0"
					+ "        order by ref desc,step asc"
					+ "    )b "
					+ ")where rn>=? and rn<=?";
		
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			ArrayList<BoardDto> list=new ArrayList<>();
			while(rs.next()) {
				int num=rs.getInt("num");
				String writer=rs.getString("writer");
				String title=rs.getString("title");
				String content=rs.getString("content");
				
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");
				
				BoardDto vo=new BoardDto(num,writer,title,content,ref,lev,step);
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
			String sql="delete from board where num=?";
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
	
	public int update(BoardDto dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=JDBCUtil.getCon();
			String sql="update board set title=?,content=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());
			
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
