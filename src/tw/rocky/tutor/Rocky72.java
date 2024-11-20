package tw.rocky.tutor;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Rocky72 {
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
				InputStream in = rs.getBinaryStream("icon");
				
				new Thread() {
					public void run() {
						try {
						String fileName = "dir3/Rocky.png";
						FileOutputStream fout = new FileOutputStream(fileName);
						byte[] buf = new byte[64 *1024];
						int len = in.read(buf);
						fout.write(buf);
						fout.flush();
						fout.close();
						System.out.println("Save OK");
						}catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
					};
				}.start();
				System.out.println("Doing...");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
