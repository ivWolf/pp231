package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
}
