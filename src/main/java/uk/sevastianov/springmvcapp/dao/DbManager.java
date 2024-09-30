package uk.sevastianov.springmvcapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    private static final String URL = "jdbc:mysql://localhost:3306/springapp";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private Connection conn;
    public DbManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed");;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return conn;
    }
}