package ru.alexander.springmvc.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.alexander.springmvc.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserClass implements UserInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user){
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findById(id);
        sessionFactory.getCurrentSession().delete(user);
    }
}
