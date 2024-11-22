package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import tw.rocky.apis.Bike;

public class Rocky73 {
	private final static String ULR = "jdbc:mysql://localhost:3306/rocky";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	private static Connection conn= null;
	private final static String SQL_UPDATE = "UPDATE member SET bike = ? WHERE id = ?";
	//物件轉存至資料庫
	public static void main(String[] args) {
		Bike bike = new Bike();
		bike.upSpeed();
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			conn = DriverManager.getConnection(ULR, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setObject(1, bike);
			pstmt.setInt(2, 1);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
