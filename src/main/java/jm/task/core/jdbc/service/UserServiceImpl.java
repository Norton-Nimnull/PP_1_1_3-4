package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.*;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl udao;
    public UserServiceImpl(){
        udao = new UserDaoJDBCImpl();
    }
    public void createUsersTable() {
udao.createUsersTable();
    }

    public void dropUsersTable() {
udao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
udao.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
udao.removeUserById(id);
    }

    public List<User> getAllUsers() {
       return  udao.getAllUsers();
    }

    public void cleanUsersTable() {
udao.cleanUsersTable();
    }
}
