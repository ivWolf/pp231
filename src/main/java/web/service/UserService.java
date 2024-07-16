package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(int count);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);
}
