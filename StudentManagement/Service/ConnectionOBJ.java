package com.myapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionOBJ {
    // Driver
    
    public static Connection getCon() {
        Connection con = null; // Local variable to hold the connection

        try {
           
            Class.forName("com.mysql.jdbc.Driver"); 
           
            con = DriverManager.getConnection("jdbc:mysql://localhost/practice", "root", "root");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed. Check output console.");
            e.printStackTrace();
        }

        return con; 
    }
}
