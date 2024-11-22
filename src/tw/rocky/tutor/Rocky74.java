package tw.rocky.tutor;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.rocky.apis.Bike;
// 讀取資料庫物件
public class Rocky74 {
	private final static String ULR = "jdbc:mysql://localhost:3306/rocky";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	private static Connection conn= null;
	private final static String SQL_QUERY = "SELECT * FROM member WHERE id = ?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		try {
			conn = DriverManager.getConnection(ULR, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			pstmt.setInt(1, 1);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String account = rs.getString("account");
				InputStream in = rs.getBinaryStream("bike");
				ObjectInputStream oin = new ObjectInputStream(in);
				Object obj = oin.readObject();
				
				if(obj instanceof Bike) {
					System.out.println("Yes");
				}else {
					System.out.println("No");
				}
				
				Bike bike = (Bike)obj;
				System.out.println(bike.getSpeed());
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
