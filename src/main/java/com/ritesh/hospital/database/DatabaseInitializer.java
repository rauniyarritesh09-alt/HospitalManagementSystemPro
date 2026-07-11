
package com.ritesh.hospital.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement()) {

            String userTable = """
                    CREATE TABLE IF NOT EXISTS users(
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        username TEXT UNIQUE,
                        password TEXT
                    );
                    """;

            stmt.execute(userTable);

            stmt.execute("""
                    INSERT OR IGNORE INTO users(username,password)
                    VALUES('admin','admin123');
                    """);

            String patientTable = """
                    CREATE TABLE IF NOT EXISTS patients(
                        patientId INTEGER PRIMARY KEY,
                        name TEXT NOT NULL,
                        age INTEGER,
                        gender TEXT,
                        disease TEXT,
                        mobile TEXT,
                        address TEXT
                    );
                    """;

            stmt.execute(patientTable);

            System.out.println("Database Initialized Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}