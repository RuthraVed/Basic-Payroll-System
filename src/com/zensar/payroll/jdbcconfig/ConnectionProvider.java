package com.zensar.payroll.jdbcconfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionProvider {
	private static Connection con;	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		if(con==null){
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/payrollDB","root","root");
		}
		return con;
	}
}
