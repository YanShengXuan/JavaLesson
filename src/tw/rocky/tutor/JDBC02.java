package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocky", "root","");
			System.out.println("OK3");
			
			Statement stmt = conn.createStatement();
//			String sql = "INSERT INTO cust (name, tel, birthday) VALUES ('AAA', '1233', '1995-07-06')";
			
//			String sql = "DELETE FROM cust WHERE id = 2";
			
//			String sql = "UPDATE cust SET tel = '3345678' WHERE id = 3";
//			stmt.execute(sql);
			
			String sql = "SELECT * FROM cust";
			ResultSet rs =  stmt.executeQuery(sql);
			
			while(rs.next()) {
			String id =  rs.getString("id");
			String name =  rs.getString("name");
			String tel =  rs.getString("tel");
			String birthday =  rs.getString("birthday");
			System.out.printf("%s : %s : %s : %s \n", id, name, tel, birthday);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
		
	}

}
