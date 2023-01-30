package com;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    private Connection connection;

    public UserService(Connection connection) {
        this.connection = connection;
    }

    public User findById(Integer id){
        return Database.getUserById(connection,id);
    }

    public User findByName(String name){
        return Database.getUserByName(connection, name);
    }
}


