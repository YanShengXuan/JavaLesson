package tw.rocky.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
	private String[] fieldNames;
	
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
		ResultSetMetaData rsmd =  rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for(int i = 0; i < fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnLabel(i + 1);
		}
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
		return fieldNames.length;
	}
	
	//row, col ==> 0-base
	public String getDate(int row, int col) {
		try {
			rs.absolute(row+1);
			return rs.getString(fieldNames[col]);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "Error";
		}
	}
	
	public String[] getFieldName() {
		return fieldNames;
	}
	//row ==> 0-base
	public void delData(int row) {
		try {
			rs.absolute(row+1);
			rs.deleteRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
	public void updateData(String newData, int row, int col) {
		try {
			rs.absolute(row+1);
			rs.updateString(col+1, newData);
			rs.updateRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	
}
