package jdbcnew;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	public static void main(String[] args) {
		String ConnectionUrl="jdbc:sqlserver://localhost:59982;"+"databaseName=Demo;integratedSecurity=true;";
		Connection Con = null;
		Statement stmt = null;
		ResultSet rs = null;
		 try{
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 Con = DriverManager.getConnection(ConnectionUrl);
			 System.out.println("Connection Established");
			  String SQL= "SELECT * FROM Employee";
			  stmt = Con.createStatement();
			  rs = stmt.executeQuery(SQL);
			  
			  while(rs.next()){
				  
				  System.out.println(rs.getString(1)+""+rs.getString(2)+""+rs.getString(3));
			  }
			  
					 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 
		 finally{
			 if(rs != null ) try{ rs.close();} catch(Exception e){}
			 if(stmt != null ) try{ stmt.close();} catch(Exception e){}
			 if(Con != null ) try{ Con.close();} catch(Exception e){}
										 
			 }
		 }
	}



