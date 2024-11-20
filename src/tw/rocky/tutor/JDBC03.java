package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入姓名");
		String name = sc.next();
		System.out.println("請輸入電話");
		String tel = sc.next();
		System.out.println("請輸入生日");
		String birthday = sc.next();
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");

		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocky", "root","")) {
			String sql = "INSERT INTO cust (name, tel, birthday) VALUES (?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			
			if(pstmt.executeUpdate() > 0) {
				System.out.println("新增成功");
			}else {
				System.out.println("新增失敗");
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
