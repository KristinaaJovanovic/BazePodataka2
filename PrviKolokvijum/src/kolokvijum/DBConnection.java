package kolokvijum;

import java.sql.*;

public class DBConnection {
	
	private static Connection conn=null;
	
	static {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/kolokvijum", "root", "root");
			
		}catch(Exception e) {
			System.out.println("Database down!");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void closeConnection() {
		try {
			if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
			System.out.println("Neuspelo zatvaranje konekcije!");
			e.printStackTrace();
		}
	}

}
