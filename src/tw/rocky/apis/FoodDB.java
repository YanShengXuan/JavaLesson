package tw.rocky.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FoodDB {
	private final static String ULR = "jdbc:mysql://localhost:3306/rocky";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	private final static String SQL_QUERY = "SELECT * FROM travel";
	
	private Connection conn;
	private ResultSet rs;
	
	public FoodDB() throws Exception{
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		conn = DriverManager.getConnection(ULR, prop);
	}
	
	public void query() throws Exception{
		query(SQL_QUERY);
	}
	
	public void query(String sql) throws Exception {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
																				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return 0;
		}
	}
	
	public int getCols() {
		return 0;
	}
	
	public String getDate() {
		return "Rocky";
	}
	
}
