package pl.ncc2.authlog;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mariadb.*;
import pl.ncc2.authlog.Sql.*;
public class WPacket {
	public static final int PORT = 9;
	
	public static void PreparePacket(String host)
	{
		
	}
	
	
	private static void GetHost(String host)
	{
		  Class.forName("org.mariadb.jdbc.Driver");
	         Connection con=DriverManager.getConnection(pl.ncc2.authlog.Sql.dbURL(),pl.ncc2.authlog.Sql.dbUser(),pl.ncc2.authlog.Sql.dbPwd());
	         PreparedStatement ps =con.prepareStatement("select * from users where login=? and pass=?");
	   //      ps.setString(1, login);
	   //      ps.setString(2, pass);
	         ResultSet rs =ps.executeQuery();
	         st = rs.next();
	         con.close();
	}
	
	private static void WPacketSend(String ip, String mac)
	{
		
	}
		
	
}
