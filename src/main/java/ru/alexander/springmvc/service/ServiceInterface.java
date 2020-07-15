package ru.alexander.springmvc.service;

import ru.alexander.springmvc.model.User;

import java.util.List;

public interface ServiceInterface {
    void add(User user);
    List<User> listUsers();
    User findById (Long id);
    void deleteUser(Long id);
    public void update(User user);
}
