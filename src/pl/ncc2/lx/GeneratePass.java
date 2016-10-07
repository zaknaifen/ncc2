package pl.ncc2.lx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GeneratePass  {
	public static boolean PreparePass(String username){
		boolean pass=false;
		if(StartLX.ProcessLx("OTP.sh "+username)){
			if(StartLX.ProcessLx("sendhash.sh "+ username))
			{
				try {
					pass=WaitForCleanPass();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		return pass;
	}

	@SuppressWarnings("deprecation")
	private static boolean WaitForCleanPass() throws InterruptedException{
		
		try{
			
		Thread WaitToClean = new Thread();
		
		WaitToClean.start();
		WaitToClean.wait();
		WaitToClean.sleep(2*60*1000);
			if(CleanPass()==true){WaitToClean.stop();}
		
		}catch (RuntimeException e)
		{}
		
		
		return true;
		
	}
	private static boolean CleanPass()
	{
		boolean ret = false;
		try {
 	 		Class.forName("org.mariadb.jdbc.Driver");
 	 		Connection con=DriverManager.getConnection(pl.ncc2.authlog.Sql.dbURL(),pl.ncc2.authlog.Sql.dbUser(),pl.ncc2.authlog.Sql.dbPwd());
 	         PreparedStatement ps=con.prepareStatement("delete * from temp_key");
 	         ps.executeUpdate();
 	         if(ps.executeUpdate()==1){
 	        	 ret = true;
 	         }
 	        
 	         
 	         con.close();
 	 	}catch(Exception e) {
 	 		e.printStackTrace();
 	 	}
    	
		
		
		return ret;
	}
	
	private static String GetPass(String username){
		String retp=null;
		
		try {
 	 		Class.forName("org.mariadb.jdbc.Driver");
 	 		Connection con=DriverManager.getConnection(pl.ncc2.authlog.Sql.dbURL(),pl.ncc2.authlog.Sql.dbUser(),pl.ncc2.authlog.Sql.dbPwd());
 	         
 	 		PreparedStatement ps=con.prepareStatement("select value from temp_key where username=? order by value desc limit 1");
 	        ps.setString(1, username);
 	 		ResultSet rs =ps.executeQuery();
 	    	 
	         while(rs.next())
	         {
	        	 retp=rs.getString("value");
	        	 
	         }
 	        
 	         
 	        
 	 	}catch(Exception e) {
 	 		e.printStackTrace();
 	 	}
		
		return retp;
	}
	
	public static boolean ValidateOTP(String username, String input)
	{
		boolean votp = false;
			if(input.equals(GetPass(username)))
					{
					votp=true;
					}
			
				return votp;
			
		
		
	}
	
}
