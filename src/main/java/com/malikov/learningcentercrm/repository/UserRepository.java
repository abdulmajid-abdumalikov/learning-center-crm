package com.malikov.learningcentercrm.repository;

import com.malikov.learningcentercrm.model.User;
import lombok.Getter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository implements BaseRepository<User> {
    @Getter
    private static final UserRepository instance = new UserRepository();

    @Override
    public void save(User model) {
        String save = "insert into users (name, username, password, role) values (?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(save);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getUsername());
            preparedStatement.setString(3, model.getPassword());
            preparedStatement.setString(4, String.valueOf(model.getRole()));
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public User update(String id, User model) {
        String update = "update users set name = ?, username = ?, password = ?, role = ? where id = ?::uuid returning *;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setString(2, model.getUsername());
            preparedStatement.setString(3, model.getPassword());
            preparedStatement.setString(4, String.valueOf(model.getRole()));
            preparedStatement.setString(5, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return User.map(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    public User login(String username, String password){
        String login = "select * from users where username =? and password =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(login);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return User.map(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<User> getUsers() {
        PreparedStatement preparedStatement = null;
        List<User> users;
        try {
            preparedStatement = connection.prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            users = new ArrayList<>();
            while (resultSet.next()) {
                User user = User.map(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void delete(String id) {
        String delete = "delete from users where id =?::uuid;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
