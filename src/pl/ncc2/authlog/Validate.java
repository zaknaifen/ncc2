package pl.ncc2.authlog;

import java.sql.*;
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
         System.out.println(ps);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
         
      }catch(Exception e)
      {
          e.printStackTrace();  
      }
         return st;                 
  }   
}
