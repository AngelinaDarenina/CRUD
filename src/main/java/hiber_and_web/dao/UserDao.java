package hiber_and_web.dao;

import hiber_and_web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();

    User getUserByID(long id);

    void save(User user);

    void update(long id, User updatedUser);

    void delete(long id);

}
