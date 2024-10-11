package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.util.*;
import jm.task.core.jdbc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Util util;
    public UserDaoJDBCImpl() {
    util = new Util();

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT not NULL AUTO_INCREMENT, " +
                " name VARCHAR(50), " +
                " lastName VARCHAR (50), " +
                " age TINYINT not NULL, " +
                " PRIMARY KEY (id))";
        try{util.getStmt().executeUpdate(SQL);}catch (SQLException se){se.printStackTrace();}
    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS users";
        try{util.getStmt().executeUpdate(SQL);}catch (SQLException se){se.printStackTrace();}
    }

    public void saveUser(String name, String lastName, byte age) {
    String SQL = "INSERT INTO users(name, lastname, age) VALUES(\'"+name+"\', \'"+lastName+"\', \'"+Integer.toString(age)+"\')";
        try{util.getStmt().executeUpdate(SQL);}catch (SQLException se){se.printStackTrace();}
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM users WHERE id="+Long.toString(id);
        try{util.getStmt().executeUpdate(SQL);}catch (SQLException se){se.printStackTrace();}
    }

    public List<User> getAllUsers() {
        ResultSet results=null;
        String SQL ="SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try{results = util.getStmt().executeQuery(SQL);
            User u;
        while (results.next()){
           u = new User(results.getString(2), results.getString(3),results.getByte(4));
            u.setId(results.getLong(1));
        list.add(u);
        }}catch (SQLException se){se.printStackTrace();}
        return list;
    }

    public void cleanUsersTable() {
        String SQL = "DELETE FROM users";
        try{util.getStmt().executeUpdate(SQL);}catch (SQLException se){se.printStackTrace();}

    }
}
