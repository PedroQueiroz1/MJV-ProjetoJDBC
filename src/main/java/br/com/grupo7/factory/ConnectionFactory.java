package br.com.grupo7.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static String url = "jdbc:postgresql://localhost:5433/grupo7banco"; 
	private static String usuario = "postgres";
	private static String senha = "admin";  
	private static String driver = "org.postgresql.Driver";
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	public ConnectionFactory() { 
		conectar();
	}
	
	private static void conectar() {
		
		try {
			if (connection == null) {
				Class.forName(driver); 
				connection = DriverManager.getConnection(url, usuario, senha);
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
