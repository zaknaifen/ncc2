package pl.ncc2.authlog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	private String dbURL ="jdbc:mariadb://localhost:3306/ncc2";
	private String user="jconn";
	private String pwd="qwopzx,.";
	private Connection connection;
	
	public DBConnectionManager() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL, user, pwd);
	}
	
	public Connection getConnection(){
		return this.connection;
	}
}
