package pl.ncc2.authlog;



public class Sql {
	private static String dbUrl="jdbc:mariadb://localhost:3306/ncc2";
	private static String dbUser="jconn";
	private static String dbPwd="qwopzx,.";
	
	
	public static String dbURL(){
		return dbUrl;
		
	}
	public static String dbUser(){
		return dbUser;
	}
	public static String dbPwd(){
		return dbPwd;
	}
	
}
