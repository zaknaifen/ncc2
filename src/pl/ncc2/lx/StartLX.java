package pl.ncc2.lx;

//importy
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;



public class StartLX {

	static File dir =null;
	static BufferedReader is=null;
	static BufferedReader es=null;
	static String LxCommand ="/srv_app/./";
	
	public StartLX() {
		
	}
	public static void ProcessLx(String cmd){
		
		try{
			//Process process;
			if(dir != null){return;}
			else{
				Process process = Runtime.getRuntime().exec(LxCommand+cmd);
				//String line;
				//is = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				
			}
				
			
			
		}catch(Exception e)
		{
			
		}
		
		
		
	}
	
	
	
}
