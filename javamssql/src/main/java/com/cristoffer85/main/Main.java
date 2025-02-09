package com.cristoffer85.main;

import com.cristoffer85.dao.UserDAO;
import com.cristoffer85.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        // Create a new user
        userDAO.createUser("Alice", "alice@example.com");

        // Read users
        List<User> users = userDAO.getUsers();
        users.forEach(System.out::println);

        // Update a user
        if (!users.isEmpty()) {
            Long userId = users.get(0).getId();
            userDAO.updateUser(userId, "Alice Updated", "alice.new@example.com");
        }

        /* Delete a user
        if (!users.isEmpty()) {
            Long userId = users.get(0).getId();
            userDAO.deleteUser(userId);
        }
        */
    }
}
