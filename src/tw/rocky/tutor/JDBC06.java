package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int rpp =10;
		System.out.print("Page ==> ");
		Scanner sc = new Scanner(System.in);
		int page = sc.nextInt();
		int start = rpp * (page - 1);
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		String url = "jdbc:mysql://localhost:3306/rocky";
		
		try {
			Connection conn = DriverManager.getConnection(url, prop);
			String sql = "SELECT id, name FROM `travel` ORDER BY id LIMIT ?,?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.printf("%s. %s\n", rs.getString("id"), rs.getString("name"));
			}
		}catch (Exception e) {
		System.out.println(e);
		}
	}

}
