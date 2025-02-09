package com.cristoffer85.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=YourDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "yourUsername";
    private static final String PASSWORD = "yourPassword";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

