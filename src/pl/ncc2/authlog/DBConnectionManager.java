package pl.ncc2.authlog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	private final String dbURL ="jdbc:mariadb://localhost:3306/ncc2";
	private final String user="jconn";
	private final String pwd="qwopzx,.";
	private Connection connection;
	
	protected DBConnectionManager() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL, user, pwd);
	}
	
	protected Connection getConnection(){
		return this.connection;
	}
}
