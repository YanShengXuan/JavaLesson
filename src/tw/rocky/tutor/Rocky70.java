package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.rocky.apis.BCrypt;
import tw.rocky.apis.Member;

public class Rocky70 {
	private final static String ULR = "jdbc:mysql://localhost:3306/rocky";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	private static Connection conn= null;
	private final static String SQL_LOGIN = "SELECT * FROM member WHERE account = ?";
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入帳號 ==> ");
		String account = sc.next();
		System.out.print("請輸入密碼 ==> ");
		String password = sc.next();
		
		try {
			Member member = isLoginSuccess(account, password);
			if(member != null) {
				System.out.println("歡迎登入");
			}else {
				System.out.println("登入失敗");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static Member isLoginSuccess (String account, String password) throws Exception {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		conn = DriverManager.getConnection(ULR, prop);
		PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
		pstmt.setString(1, account);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			String hashPassworld = rs.getString("password");
			if(BCrypt.checkpw(password, hashPassworld)) {
				return new Member(rs.getInt("id"), account, hashPassworld, rs.getString("name"));
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}
