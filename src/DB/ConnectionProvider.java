package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	static Connection con = null;

	static String url = "url";
	
	public static Connection getCon() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(url, "id", "password");
		} catch (Exception e) {
			System.out.println(e + "¹ß»ý");
		}
		return con;
	}
}
