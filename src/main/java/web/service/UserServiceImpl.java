package web.service;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void insertUser(User user){
        userDao.insertUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User updateUser){
        userDao.updateUser(updateUser);

    }

    @Transactional
    @Override
    public void deleteUser(User user){
        userDao.deleteUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

}