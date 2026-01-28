package org.example;

import java.sql.*;

public class DbConfig {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;databaseName=userDb;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "Akshay@1234";

    public static void main(String[] args) {

        String sql = "INSERT INTO Customers (CustomerID,FirstName,LastName,Address,City,Country) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            System.out.println("✅ Database connected successfully!");

            SelectCust(conn);

        } catch (SQLException e) {
            System.err.println("❌ Database connection failed");
            e.printStackTrace();
        }
    }

    public static void SelectCust(Connection conn){
        String sql = "Select * from Customers";
        try(PreparedStatement stmt = conn.prepareStatement(sql);){
         ResultSet rs  = stmt.executeQuery();

         while (rs.next()){
             int CustId = rs.getInt("CustomerID");
             String FirstName = rs.getString("FirstName");
             String LastName = rs.getString("LastName");
             String Add  = rs.getString("Address");
             String City =  rs.getString("City");
             String Contry = rs.getString("Country");

             System.out.println(
                     "CustId   : " + CustId + "\n" +
                             "FirstName: " + FirstName + "\n" +
                             "LastName : " + LastName + "\n" +
                             "Address  : " + Add + "\n" +
                             "City     : " + City + "\n" +
                             "Country  : " + Contry
             );

         }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

     public static void InsertCust(Connection conn, int CustId, String FirstName, String LastName, String Add , String City , String Contry)  {
         String sql = "INSERT INTO Customers (CustomerID,FirstName,LastName,Address,City,Country) VALUES(?,?,?,?,?,?)";

         PreparedStatement stmt = null;
         try {
             stmt = conn.prepareStatement(sql);
             stmt.setInt(1,CustId);
             stmt.setString(2,FirstName);
             stmt.setString(3,LastName);
             stmt.setString(4,Add);
             stmt.setString(5,City);
             stmt.setString(6,Contry);
             int rows = stmt.executeUpdate();
             System.out.println(rows + " student inserted successfully.");
             conn.close();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }


     }

}
