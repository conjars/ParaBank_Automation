package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

	// Steps to be followed while connecting to DB and getting the details from DB

//	1. DB_Connection_URL
//	2. User name and apssword
//	

	// 1. Declare the DataBase Connection Variable
	public static final String DB_URL = "jdbc:parasoft:proxydriver:org.hsqldb.jdbcDriver:@jdbc:hsqldb:hsql://localhost/parabank";
	public static String DB_User = "sa";
	public static String DB_Password = "";

	// 2. Connection to the Database

	public static Connection getConnection_SQL() {

		Connection con = null;

		try {

			Class.forName("com.parasoft.xtest.jdbc.virt.driver.JDBCProxyDriver"); // loading ur sql jdbc driver
			con = DriverManager.getConnection(DB_URL, DB_User, DB_Password);
			
			if(con!= null)
			{
				System.out.println("Connection established");
			}
			else
			{
				System.out.println("Connection establised failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	

}
