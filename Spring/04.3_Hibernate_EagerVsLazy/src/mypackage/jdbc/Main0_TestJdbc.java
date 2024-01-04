package mypackage.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main0_TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to databse: "+jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
