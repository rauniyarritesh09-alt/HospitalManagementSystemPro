
package com.ritesh.hospital.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:hospital.db";

    public static Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(URL);
            System.out.println("Database Connected Successfully!");
            return con;

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}