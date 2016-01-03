package dao;

import domain.User;

import java.util.List;

/**
 * Created by Андрей on 03.01.2016.
 */
public interface UserDao {
    String create(User user);
    User read(String login);
    void update(User user);
    void delete(User user);
    List findAll();
    User getUserByLoginAndPassword(String login, String password);
}