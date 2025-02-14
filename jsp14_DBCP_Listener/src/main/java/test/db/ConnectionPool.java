package test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * [[ 컨넥션 풀 ]]
 * - DBMS와 접속된 컨넥션들을 여러개 만들어 놓고(컨넥션풀) DB와 접속할때
 * 	 사용중이지 않은 컨넥션객체를 얻어와 사용하고 작업이 끝나면
 * 	 컨넥션객체를 다시 반환한다.
 * - 성능향상을 위햐 사용한다.
 */
public class ConnectionPool {
	private HashMap<Connection,Boolean> h; //pool장(컨넥션풀 역할)
	private int increment = 3; //컨넥션이 모두 사용중일때 증가할 컨넥션 수
	String url;
	String usr;
	String pwd;
	
	public ConnectionPool() throws SQLException{
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
		}catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
		
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		usr = "c##scott";
		pwd = "tiger";
		
		h = new HashMap<Connection, Boolean>();
		
		for(int i=0;i<5;i++) {
			//컨넥션 객체 얻어오기
			con=DriverManager.getConnection(url,usr,pwd);
			//컨넥션객체를 Map에 담기(사용중이 아닌 상태라는 표시로 false저장)
			h.put(con, false);
		}
	}
	
	public synchronized Connection getConnection() throws SQLException{
		Connection con = null;
		Boolean b = null;
		Set<Connection> e = h.keySet();
		Iterator<Connection> it = e.iterator();
		
		while(it.hasNext()) {
			//Map에서 컨넥션 얻어오기
			con=it.next();
			//상태 얻어오기 (사용중:true, 사용중이 아님:false)
			b = h.get(con);
			if(!b) {  //사용중이지 않으면 = !(false)
				h.put(con, true); //사용중인 상태(true)로 바꾸고
				return con;  //컨넥션 리턴
			}
		}
		
		//컨넥션이 모두 사용중일때 새로운 컨넥션을 3개 얻어와 Map에 저장
		for(int i=0;i<increment;i++) {
			h.put(DriverManager.getConnection(url,usr,pwd), false);
		}
		return getConnection();
	}
	
	//닫고자하는 컨넥션 받아온다
	public void closeConnection(Connection closeCon) throws SQLException {
		Connection con = null;
		Set<Connection> e = h.keySet();
		Iterator<Connection> it = e.iterator();
		
		while(it.hasNext()) {
			con=it.next();		
			if(con == closeCon) {
				h.put(con, Boolean.FALSE);
				break;
			}
		}
		keepConsu(5);  //사용중이지 않은 컨넥션객체를 5개로 유지하기
	}
	
	//false갯수를 세기위한 메소드
	public void keepConsu(int su) throws SQLException{
		Connection con = null;
		Boolean b = null;
		int count = 0;
		
		Set<Connection> e = h.keySet();
		Iterator<Connection> it = e.iterator();
		
		while(it.hasNext()) {
			con=it.next();
			b = h.get(con);
			if(!b) { //컨넥션이 사용중이 아니면
				count++;  //사용중이지 않은 컨넥션 갯수 세기
				if(count > su) {  //사용중이지 않은 컨넥션이 5보다 크면
					h.remove(con); //Map에서 제거하기
					con.close();  //db접속 해제하기
				}
			}
		}
	}
	
	public void closeAll() throws SQLException{
		Connection con=null;
		Set<Connection> e=h.keySet();
		Iterator<Connection> it=e.iterator();
		while(it.hasNext()) {
			con=it.next();
			h.remove(con);
			con.close();
		}
	}

}
