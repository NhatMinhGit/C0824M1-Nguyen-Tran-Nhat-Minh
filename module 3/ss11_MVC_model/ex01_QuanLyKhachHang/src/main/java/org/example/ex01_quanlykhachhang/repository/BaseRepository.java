package org.example.ex01_quanlykhachhang.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/CustomerDB?useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "123456789";
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
