package com;

import java.util.List;

public class Database {
    private static List<User> users = List.of(
            new User(1, "Ivan"),
            new User(2, "Andrey"),
            new User(3, "Igor"));

    public static User getUserById(Connection connection, Integer id) {
        if (connectionValid(connection)) {
            for (User user : users) {
                if (user.getId().equals(id)) {
                    return user;
                }
            }
        } else {
            throw new RuntimeException
                    ("Не удалось установить соединение с бд");
        }
        return null;
    }

    public static User getUserByName(Connection connection, String name) {
        if (connectionValid(connection)) {
            for (User user : users) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        } else {
            throw new RuntimeException
                    ("Не удалось установить соединение с бд");
        }
        return null;
    }

    public static boolean connectionValid(Connection connection) {
        String address = "localhost";
        String password = "1234";
        String username = "admin";
        return username.equals(connection.getUsername()) &&
                password.equals(connection.getPassword()) &&
                address.equals(connection.getAddress());
    }
}
