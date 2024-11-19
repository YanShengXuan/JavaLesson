package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocky?user=root&password=");
//			System.out.println("OK1");
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
		
		
//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocky", "root","");
//			System.out.println("OK2");
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
		
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root","");
			System.out.println("OK3");
			
//			conn.createStatement().execute("use rocky");
			System.out.println(conn.createStatement().execute("use rocky"));
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
		
	}

}
