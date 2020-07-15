package ru.alexander.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexander.springmvc.DAO.UserInterface;
import ru.alexander.springmvc.model.User;

import java.util.List;

@Service
public class ServiceClass implements ServiceInterface {

    @Autowired
    private UserInterface userInterface;

    @Transactional
    @Override
    public void add(User user) {
        userInterface.add(user);
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userInterface.listUsers();
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return userInterface.findById(id);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userInterface.deleteUser(id);
    }

    @Transactional
    @Override
    public void update(User user){
        userInterface.update(user);
    }


}
