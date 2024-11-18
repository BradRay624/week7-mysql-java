package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String SCHEMA = "projects";
    private static final String USER = "projects";
    private static final String PASSWORD = "projects";

    public static Connection getConnection() {
        String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", HOST, PORT, SCHEMA);
        System.out.println("Connecting with url" + url);
        try {
            Connection conn = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Connection successful!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error obtaining database connection.");
            throw new DbException("Unable to connect to database.", e);
        }
    }
}