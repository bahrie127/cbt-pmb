package com.bahri.pmb.service.impl;


import com.bahri.pmb.domain.Role;
import com.bahri.pmb.domain.User;
import com.bahri.pmb.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: latief
 * Date: 5/15/12
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        if(user.getUsername() != null){
            User rg = (User) sessionFactory.getCurrentSession().get(User.class, user.getUsername());
            if(rg != null) sessionFactory.getCurrentSession().evict(rg);
        }
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void update(String oldUsername, String newUsername, String newPassword, String newSalt) {
        if(newPassword == null || newPassword.isEmpty()){
            sessionFactory.getCurrentSession()
                    .createQuery("update User u set u.username = :newUsername where u.username = :oldUsername")
                    .setParameter("oldUsername", oldUsername).setParameter("newUsername", newUsername)
                    .executeUpdate();
        }
        else if(newPassword != null && !newPassword.isEmpty()){
            sessionFactory.getCurrentSession()
                    .createQuery("update User u " +
                            "set u.username = :newUsername, u.password = :newPassword, u.salt = :newSalt " +
                            "where u.username = :oldUsername")
                    .setParameter("oldUsername", oldUsername).setParameter("newUsername", newUsername)
                    .setParameter("newPassword", newPassword).setParameter("newSalt", newSalt)
                    .executeUpdate();
        }
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void deleteMore(User[] users) {
        if(users != null){
            for(User user:users){
                delete(user);
            }
        }
    }

    @Override
    public User findUser(String username) {
        return (User) sessionFactory.getCurrentSession().get(User.class, username);
    }

    @Override
    public List<User> findUsers() {
        List<User> users = (List<User>) sessionFactory.getCurrentSession().createQuery("from User rg").list();
        return users;
    }

    @Override
    public List<User> findUsers(Role role) {
        List<User> users = (List<User>) sessionFactory.getCurrentSession().createQuery("from User rg where rg.role=:role").setParameter("role",role).list();
        return users;
    }

    @Override
    public List<User> findUsers(int first, int max) {
        List<User> users = (List<User>) sessionFactory.getCurrentSession().createQuery("from User rg").setFirstResult(first).setMaxResults(max).list();
        return users;
    }

    @Override
    public Long countUsers() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(rg) from User rg").uniqueResult();
    }
}
