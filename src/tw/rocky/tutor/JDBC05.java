package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC05 {
//模糊搜索
	public static void main(String[] args) {
		System.out.print("請輸入關鍵字 ==>");
		Scanner sc = new Scanner(System.in);
		String key = sc.next();
		
		String sql = "SELECT * FROM travel WHERE name LIKE ? OR address LIKE ? OR tel LIKE ? OR introduction LIKE ?";
		String kw = "%" + key + "%";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		String url = "jdbc:mysql://localhost:3306/rocky";
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kw);
			pstmt.setString(2, kw);
			pstmt.setString(3, kw);
			pstmt.setString(4, kw);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String introduction = rs.getString("introduction");
				System.out.printf("%s : %s : %s \n", name, address, tel);
				System.out.println("--------------------------");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
