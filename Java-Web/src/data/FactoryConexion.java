package data;

import java.sql.*;

public class FactoryConexion {
	private String driver = "com.mysql.cj.jdbc.Driver";
	//private String host = "localhost";
	//private String port = "3306";
	private String username = "root";
	private String password = "catriel";
	//private String db = "cabana";
	String url = "jdbc:mysql://localhost:3306/cabana"+"?useTimezone=true&serverTimezone=UTC";
	/*
	 * private String driver="com.mysql.jdbc.Driver"; private String
	 * host="localhost"; private String port="3306"; private String user="root";
	 * private String password="root"; private String db="tpjava";
	 */

	private static FactoryConexion instancia;

	private FactoryConexion() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static FactoryConexion getInstancia() {
		if (FactoryConexion.instancia == null) {
			FactoryConexion.instancia = new FactoryConexion();
		}
		return FactoryConexion.instancia;

	}

	private Connection conn;
	private int cantConn = 0;

	public Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url, username, password);
				// conn = DriverManager.getConnection(
				//"jdbc:mysql://"+host+":"+port+"/"+db+"?useTimezone=true&serverTimezone=UTC"+"?user="+username+"&password="+password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cantConn++;
		return conn;
	}

	public void releaseConn() {
		try {
			cantConn--;
			if (cantConn == 0) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}