package dao;

import domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Андрей on 03.01.2016.
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @Autowired(required = true)
    private SessionFactory factory;

    public UserDaoImpl() {
    }

    @Override
    public String create(User user) {
        return (String)factory.getCurrentSession().save(user);
    }

    @Override
    public User read(String login) {
        return (User) factory.getCurrentSession().get(User.class, login);
    }

    @Override
    public void update(User user) {
        factory.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        factory.getCurrentSession().delete(user);
    }

    @Override
    public List findAll() {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from User");
        return query.list();
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("from User op where op.login=:login AND op.password=:password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (User)query.uniqueResult();
    }
}