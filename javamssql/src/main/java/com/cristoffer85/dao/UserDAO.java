package com.cristoffer85.dao;

import com.cristoffer85.model.User;
import com.cristoffer85.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    /* Doesn't work with SQL Server, dont know why its a longer fault search but didnt have time for it right now
    
    // Create table if not exists
    public void createUsersTable() {
        String sql = "IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='users' AND xtype='U') " +
                     "CREATE TABLE users (" +
                     "id BIGINT IDENTITY(1,1) PRIMARY KEY, " +
                     "name VARCHAR(100) NOT NULL, " +
                     "email VARCHAR(100) NOT NULL);";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Users table checked and created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/      

    // Create
    public void createUser(String name, String email) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("User created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(new User(rs.getLong("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Update
    public void updateUser(Long id, String name, String email) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setLong(3, id);
            stmt.executeUpdate();
            System.out.println("User updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            System.out.println("User deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}