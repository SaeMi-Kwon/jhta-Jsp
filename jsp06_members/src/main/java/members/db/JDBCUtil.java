package members.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getCon() {
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			con=DriverManager.getConnection(url,"c##scott","tiger");
			System.out.println("db접속성공");
			
			return con;
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce.getMessage());
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
		return null; 
	}
	
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt!=null) stmt.close();
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs!=null) rs.close();
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
	public static void close(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		} catch (SQLException s) {
			System.out.println(s.getMessage());
		}
	}
	
}
