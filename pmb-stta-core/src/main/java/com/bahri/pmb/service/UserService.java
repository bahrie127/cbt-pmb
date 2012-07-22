package com.bahri.pmb.service;

import com.bahri.pmb.domain.Role;
import com.bahri.pmb.domain.User;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: latief
 * Date: 5/15/12
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public void save(User user);
    public void update(User user);
    public void update(String oldUsername, String newUsername, String newPassword, String salt);
    public void delete(User user);
    public void deleteMore(User[] users);
    public User findUser(String username);
    public List<User> findUsers();
    public List<User> findUsers(Role role);
    public List<User> findUsers(int first, int max);
    public Long countUsers();
}
