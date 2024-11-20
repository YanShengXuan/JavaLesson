package tw.rocky.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
//透過JSON載入資料，建立資料庫
public class JDBC04 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAttractions.aspx");
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			StringBuffer sb = new StringBuffer();
			System.out.println("OK1");
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("OK2");
			parseJSON(sb.toString());
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	private static void parseJSON(String json) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "");
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rocky", prop)) {
			String sqlDel = "DELET FROM travel";
			conn.prepareStatement(sqlDel).executeUpdate();
			String sqlZero = "ALTER TABLE travel AUTO_INCREMENT = 1";
			conn.prepareStatement(sqlZero).executeUpdate();
			
			String sql = "INSERT INTO travel (name, tel, address, introduction, latitude, longitude, picurl) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			JSONArray root = new JSONArray(json);
			for(int i = 0; i < root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String tel = row.getString("Tel");
				String address = row.getString("Address");
				String introduction = row.getString("Introduction");
				String latitude = row.getString("Latitude");
				String longitude = row.getString("Longitude");
				String picurl = row.getString("Photo");
				
				pstmt.setString(1, name);
				pstmt.setString(2, tel);
				pstmt.setString(3, address);
				pstmt.setString(4, introduction);
				pstmt.setString(5, latitude);
				pstmt.setString(6, longitude);
				pstmt.setString(7, picurl);
				pstmt.executeUpdate();
			}
			System.out.println("OK3");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
