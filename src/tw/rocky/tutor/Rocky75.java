package tw.rocky.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Rocky75 {
//找出員工編號、名稱，計算出總銷售額
	
//	SELECT e.EmployeeID, e.LastName, SUM(od.UnitPrice * od.Quantity) rev FROM orders o
//	JOIN orderdetails od ON (o.OrderID = od.OrderID)
//	JOIN employees e ON (o.EmployeeID = e.EmployeeID)
//	GROUP BY o.EmployeeID
//	ORDER BY tatle DESC
	
	
//	SELECT SUM(UnitPrice * Quantity) FROM orderdetails
//	WHERE OrderID IN (
//	SELECT OrderID FROM orders WHERE EmployeeID = 4
	private final static String ULR = "jdbc:mysql://localhost:3306/northwind";
	private final static String USER = "root";
	private final static String PASSWORD = "";
	private static Connection conn= null;
	private final static String SQL_QUERY = 
			"	SELECT e.EmployeeID id, e.LastName name, SUM(od.UnitPrice * od.Quantity) rev FROM orders o"
		+ "	JOIN orderdetails od ON (o.OrderID = od.OrderID)"
		+ "	JOIN employees e ON (o.EmployeeID = e.EmployeeID)"
		+ "	GROUP BY o.EmployeeID"
		+ "	ORDER BY rev DESC";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		
		try {
			conn = DriverManager.getConnection(ULR, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL_QUERY);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String rev = rs.getString("rev");
				System.out.printf("%s %s %s\n", id, name, rev);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
