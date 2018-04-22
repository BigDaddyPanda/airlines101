package aeroport;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connecter {
	static public Connection conn=null;
	static public void connecter() {
		String url ="jdbc:mysql://localhost:3306/formationdatabase";
	 	   
	 	   String driver ="com.mysql.jdbc.Driver";
	 	   String user="root";
	 	   String password="";
	 	   try{
	 		   Class.forName(driver);
	 		  
	 	   }catch (ClassNotFoundException  e){e.printStackTrace();
	 	   System.out.println("erreur driver");
	 		System.out.println(e.getMessage());}
	 	   
	 	   
	 	   try{
	 		   conn= DriverManager.getConnection(url, user, password);		
	 		 
	 		  	}catch(SQLException e){System.out.println(e);}

	}
}
