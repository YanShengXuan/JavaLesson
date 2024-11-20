package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import tw.rocky.apis.BCrypt;

public class Rocky69 {
// bcrypt 加密，帳號密碼存入資料庫
	private final static String ULR = "jdbc:mysql://localhost:3306/rocky";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	private static Connection conn= null;
	private final static String SQL_CHECK = "SELECT count(*) cnt FROM member WHERE account = ?";
	private final static String SQL_REGISTER = "INSERT INTO member (account, password, name) VALUES (?, ?, ?)";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("請輸入帳號 ==> ");
		String account = sc.next();
		System.out.print("請輸入密碼 ==> ");
		String password = sc.next();
		System.out.print("請輸入暱稱 ==> ");
		String name = sc.next();
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		
		try {
			conn = DriverManager.getConnection(ULR, prop);
			if (!isAccountExist(account)) {
				try {
					registerAccount(account, password, name);
					System.out.println("註冊成功");
					
				} catch (Exception e1) {
					System.out.println(e1);
					System.out.println("註冊失敗");
				}
			}else {
				System.out.println("帳號已存在，請重新輸入");
			}
		} catch (SQLException e2) {
			System.out.println(e2);
		}
	}
	static boolean isAccountExist(String account) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL_CHECK);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("cnt") > 0;
			
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	static void registerAccount(String account, String password, String name) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(SQL_REGISTER);
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(password, BCrypt.gensalt()));
		pstmt.setString(3, name);
		
		int n = pstmt.executeUpdate();
		if(n == 0) throw new Exception();
	}
}
