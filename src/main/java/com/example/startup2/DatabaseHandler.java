package com.example.startup2;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/startup_db";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public static void insertData(String type, String name, double amount, int months) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO history (type, name, amount, months) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, type);
                statement.setString(2, name);
                statement.setDouble(3, amount);
                statement.setInt(4, months);
             //   statement.setDouble(5, total);
              //  statement.setDouble(6, profit);
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
