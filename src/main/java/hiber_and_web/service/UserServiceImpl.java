package hiber_and_web.service;

import hiber_and_web.dao.UserDao;
import hiber_and_web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByID(long id) {
        return userDao.getUserByID(id);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }
}
