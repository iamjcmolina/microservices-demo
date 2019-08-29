package com.example.userservice.service.impl;

import com.example.userservice.dao.UserDao;
import com.example.userservice.dao.exception.UserDaoException;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User update(Long id, User user) {
        return userDao.update(id, user);
    }

    @Override
    public User delete(Long id) {
        Integer userPostsCount = userDao.countPostsByUserId(id);
        if (userPostsCount > 0)
            throw new UserDaoException("No se puede desactivar el usuario porque tiene posts activos");
        return userDao.delete(id);
    }

    @Override
    public User restore(Long id) {
        return userDao.restore(id);
    }
}
