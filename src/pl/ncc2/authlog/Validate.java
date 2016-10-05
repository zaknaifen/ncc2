package pl.ncc2.authlog;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.mariadb.*;
import pl.ncc2.authlog.Sql.*;
public class Validate 
 {
     public static boolean checkUser(String login,String pass) 
     {
      boolean st =false;
      try{
          	  Class.forName("org.mariadb.jdbc.Driver");
         Connection con=DriverManager.getConnection(pl.ncc2.authlog.Sql.dbURL(),pl.ncc2.authlog.Sql.dbUser(),pl.ncc2.authlog.Sql.dbPwd());
         PreparedStatement ps =con.prepareStatement("select * from users where login=? and pass=?");
         ps.setString(1, login);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
         con.close();
      }catch(Exception e)
      {
          e.printStackTrace();  
      }
         return st;                 
  }   
     public static boolean CheckKey(String key)
     {
    	 boolean st=false;
    	 	try {
    	 		Class.forName("org.mariadb.jdbc.Driver");
    	 		Connection con=DriverManager.getConnection(pl.ncc2.authlog.Sql.dbURL(),pl.ncc2.authlog.Sql.dbUser(),pl.ncc2.authlog.Sql.dbPwd());
    	         PreparedStatement ps=con.prepareStatement("select * from pv_key_byday where day=? and value=?");
    	         
    	         String day_now= new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
    	        
    	         day_now = day_now.replaceFirst("^0*", "");
    	         
    	         ps.setString(1, day_now);
    	         ps.setString(2, key);
    	         
    	         ResultSet rs =ps.executeQuery();
    	 
    	         st = rs.next();
    	         con.close();
    	 	}catch(Exception e) {
    	 		e.printStackTrace();
    	 	}
    	 return st;
     }
     
     public static void InsertSession(String key){
    	 try {
 	 		Class.forName("org.mariadb.jdbc.Driver");
 	 		Connection con=DriverManager.getConnection(pl.ncc2.authlog.Sql.dbURL(),pl.ncc2.authlog.Sql.dbUser(),pl.ncc2.authlog.Sql.dbPwd());
 	         PreparedStatement ps=con.prepareStatement("insert into skey(ses) values(?)");
 	         
 	         String day_now= new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
 	        
 	         day_now = day_now.replaceFirst("^0*", "");
 	         
 	         ps.setString(1, day_now);
 	         ps.setString(2, key);
 	         
 	         ResultSet rs =ps.executeQuery();
 	 
 	         st = rs.next();
 	         con.close();
 	 	}catch(Exception e) {
 	 		e.printStackTrace();
 	 	}
 
     }
     
     
}
