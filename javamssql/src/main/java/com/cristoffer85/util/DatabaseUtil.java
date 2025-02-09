package com.cristoffer85.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    static String URL = System.getenv("DB_URL");
    static String USER = System.getenv("DB_USER");
    static String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /* Doesn't work with SQL Server, dont know why its a longer fault search but didnt have time for it right now

    // Create database if not exists
    public static void createDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            String sql = "IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'JavaMSSQLJDBC') CREATE DATABASE JavaMSSQLJDBC;";
            stmt.executeUpdate(sql);
            System.out.println("Database checked/created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
}