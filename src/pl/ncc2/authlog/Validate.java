package pl.ncc2.authlog;

import java.sql.*;
import org.mariadb.*;
public class Validate
 {
	 private static String url= pl.ncc2.authlog.Sql.dbURL();
	  private static String duser=pl.ncc2.authlog.Sql.dbUser();
	  private static String dpass=pl.ncc2.authlog.Sql.dbPwd();
	
	
	  
	  
	  
	  
     public static boolean checkUser(String login,String pass) 
     {
      boolean st =false;
      try{
    	 
	 
          	  Class.forName("org.mariadb.jdbc.Driver");
         Connection con=DriverManager.getConnection(url,duser,dpass);
         PreparedStatement ps =con.prepareStatement("select * from users where login=? and pass=?");
         ps.setString(1, login);
         ps.setString(2, pass);
         System.out.println(ps);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
         
      }catch(Exception e)
      {
          e.printStackTrace();
          
          System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
      
      }
         return st;                 
  }   
}
