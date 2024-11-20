package tw.rocky.tutor;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Rocky71 {
	private final static String ULR = "jdbc:mysql://localhost:3306/rocky";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	private static Connection conn= null;
	private final static String SQL_UPDATE = "UPDATE member SET icon = ? WHERE id = ?";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			conn = DriverManager.getConnection(ULR, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setBinaryStream(1, new FileInputStream("dir2/ball2.png"));
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
		
		
		

	}

}
