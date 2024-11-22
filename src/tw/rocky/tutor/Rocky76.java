package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Rocky76 {
	//增刪修 特定位置
	private final static String ULR = "jdbc:mysql://localhost:3306/rocky";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	private static Connection conn= null;
	private final static String SQL_QUERY = 
			"SELECT * FROM travel";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		
		try {
			conn = DriverManager.getConnection(ULR, prop);
			//須加兩個元素達到效果
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE,
																																ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s \t %s\n", id, name);
			}
			System.out.println("--------------------------");
			if(rs.absolute(5)) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s \t %s\n", id, name);
			}
			System.out.println("--------------------------");
			if(rs.previous()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s \t %s\n", id, name);
			}
			System.out.println("--------------------------");
			if(rs.first()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s \t %s\n", id, name);
			}
			System.out.println("--------------------------");
			if(rs.last()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s \t %s\n", id, name);
			}
			//更改資料
			System.out.println("--------------------------");
			if(rs.absolute(3)) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s \t %s\n", id, name);
				rs.updateString("name", "草尼瑪農業區");
				rs.updateString("tel", "0425468545");
				rs.updateRow();
			}
			//刪除
			System.out.println("--------------------------");
			if(rs.absolute(20)) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s \t %s\n", id, name);
				rs.deleteRow();
				id = rs.getString("id");
				name = rs.getString("name");
				System.out.printf("%s \t %s\n", id, name);
			}
			//新增
			rs.moveToInsertRow();
			rs.updateString("name", "33456789");
			rs.updateString("tel", "0912345678");
			rs.insertRow();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
