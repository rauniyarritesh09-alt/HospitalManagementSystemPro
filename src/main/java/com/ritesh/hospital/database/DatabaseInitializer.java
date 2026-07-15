
package com.ritesh.hospital.database;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initializeDatabase() {

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement()) {

            // Users Table
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

            // Patients Table
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

            // Doctors Table
            String doctorTable = """
                    CREATE TABLE IF NOT EXISTS doctors(
                        doctorId INTEGER PRIMARY KEY,
                        name TEXT NOT NULL,
                        specialization TEXT,
                        qualification TEXT,
                        experience INTEGER,
                        mobile TEXT,
                        email TEXT
                    );
                    """;

            stmt.execute(doctorTable);

            // Appointments Table
            String appointmentTable = """
                    CREATE TABLE IF NOT EXISTS appointments(
                        appointmentId INTEGER PRIMARY KEY,
                        patientId INTEGER NOT NULL,
                        doctorId INTEGER NOT NULL,
                        appointmentDate TEXT NOT NULL,
                        appointmentTime TEXT NOT NULL,
                        status TEXT NOT NULL
                    );
                    """;

            stmt.execute(appointmentTable);

            String billTable = """
    CREATE TABLE IF NOT EXISTS bills(
        billId INTEGER PRIMARY KEY,
        patientId INTEGER,
        doctorId INTEGER,
        consultationFee INTEGER,
        medicineCharge INTEGER,
        testCharge INTEGER,
        otherCharge INTEGER,
        totalAmount INTEGER,
        paymentMode TEXT,
        billDate TEXT
    );
    """;

            stmt.execute(billTable);

            System.out.println("Database Initialized Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}