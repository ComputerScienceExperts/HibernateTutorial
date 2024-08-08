package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getMysqlConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("mysql:jdbc://localhost:3306/hibernateorg", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

}
