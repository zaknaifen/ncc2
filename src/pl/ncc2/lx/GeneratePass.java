package pl.ncc2.lx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class GeneratePass  {
	public String PreparePass(){
		String pass = null;
		if(StartLX.ProcessLx("OTP.sh")){
		
			
			
		}
		
		return pass;
	}

	@SuppressWarnings("deprecation")
	private static boolean WaitForCleanPass() throws InterruptedException{
		
		try{
			
		Thread WaitToClean = new Thread();
		WaitToClean.start();
		WaitToClean.wait();
		WaitToClean.sleep(30*60*1000);
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
	
}
