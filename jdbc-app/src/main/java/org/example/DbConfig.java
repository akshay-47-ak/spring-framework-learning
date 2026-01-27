package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConfig {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=userDb;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "Akshay@1234";

    public static void main(String[] args) {

        String sql = "INSERT INTO Customers (CustomerID,FirstName,LastName,Address,City,Country) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("✅ Database connected successfully!");

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1,1);
            stmt.setString(2,"Akshay");
            stmt.setString(3,"Athavale");
            stmt.setString(4,"Akluj");
            stmt.setString(5,"Akluj");
            stmt.setString(6,"INDIA");


            int rows = stmt.executeUpdate();
            System.out.println(rows + " student inserted successfully.");
             conn.close();
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed");
            e.printStackTrace();
        }
    }
}
