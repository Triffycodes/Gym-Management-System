package adhi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static Connection con;

	public static Connection getConnection() {
		// step1 load the driver class
		try {
			System.out.println("..............................");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// step2 create the connection object
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "adarsh");
			System.out.println("Database Connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}
}
