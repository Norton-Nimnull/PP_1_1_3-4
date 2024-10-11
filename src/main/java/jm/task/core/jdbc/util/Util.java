package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String USER = "norton";
    private static final String PASSWORD = "nimnull";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection con;
    private static Statement stmt;
    public Util(){
        try{Class.forName(JDBC_DRIVER);}catch (ClassNotFoundException ce){ce.printStackTrace();}
        try{con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);}catch (SQLException se){se.printStackTrace();}
        try{stmt = con.createStatement();}catch (SQLException se){se.printStackTrace();}
    }

    public static Connection getCon() {
        return con;
    }

    public static Statement getStmt() {
        return stmt;
    }
}
