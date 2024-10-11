package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
  //public UserServiceImpl usi;

    public static void main(String[] args) {
        UserServiceImpl usi = new UserServiceImpl();
usi.createUsersTable();
usi.saveUser("ass","bigass",(byte)66);
usi.saveUser("29A666","cunt",(byte)99);
//usi.removeUserById(2l);
//usi.cleanUsersTable();
System.out.println(usi.getAllUsers().toString());
        }
    }
