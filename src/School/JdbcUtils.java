package School;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
 public static Connection buildConnection() throws SQLException {
	 String url = "jdbc:mysql://localhost:3306/sms";
		String userId = "root";
		String password = "ABHI123";
		Connection dbConnection = DriverManager.getConnection(url, userId, password);
		return dbConnection;
 }
}
