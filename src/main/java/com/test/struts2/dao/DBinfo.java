package com.test.struts2.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public interface DBinfo {
	static final String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String dbURL="jdbc:sqlserver://localhost:1433;databaseName=MPLogistics;";
    static final String userDB="sa";
    static final String passDB="123";
    public static Connection getConnectDB() {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL, userDB, passDB);
		} catch (Exception ex) {
			System.out.println("connect failure!");
			ex.printStackTrace();
		}
		return conn;
	}
}