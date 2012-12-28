package utils;

import java.sql.Connection;
import java.sql.DriverManager;
//This class sets up the connection to the project's database

public class DatabaseUtil {

	private static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection!=null) {
			return connection;
		} else {
			try {

				Class.forName("com.mysql.jdbc.Driver").newInstance(); 
				String dbURL = "jdbc:mysql://localhost:3306/Squizam";
				String user = "root";//"megumi";
				String password = "";//"milkshake"; 
				connection = DriverManager.getConnection(dbURL, user, password);
				return connection;
				
			} catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
		}

	}

}
