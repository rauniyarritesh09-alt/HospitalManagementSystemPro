
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoctorListService {

    public ResultSet getAllDoctors() {

        try {

            Connection con = DatabaseConnection.getConnection();

            Statement stmt = con.createStatement();

            return stmt.executeQuery("SELECT * FROM doctors");

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }
    }
}