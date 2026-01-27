package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=userDb;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "Akshay@1234";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            System.out.println("✅ Database connected successfully!");

        } catch (SQLException e) {
            System.err.println("❌ Database connection failed");
            e.printStackTrace();
        }
    }
}
