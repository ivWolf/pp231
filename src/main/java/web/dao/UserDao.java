package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void updateUser(User user);

    List<User> getUsers(int count);

    void deleteUser(Long id);

    User getUserById(Long id);
}
