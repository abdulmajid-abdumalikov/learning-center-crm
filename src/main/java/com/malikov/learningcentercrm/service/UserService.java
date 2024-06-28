package com.malikov.learningcentercrm.service;

import com.malikov.learningcentercrm.model.User;
import com.malikov.learningcentercrm.repository.UserRepository;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

public class UserService extends BaseService<UserRepository, User> {

    @Getter
    private static final UserService instance = new UserService();

    private UserService() {
        super(UserRepository.getInstance());
    }

    @Override
    public void save(User model) {
         super.save(model);
    }

    @Override
    public User findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public boolean deleteById(Integer id) {
        return super.deleteById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return super.findAll();
    }

    @Override
    public User update(String id, User model) {
        return super.update(id, model);
    }

    public User login(String username, String password) {
        return repository.login(username, password);
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
