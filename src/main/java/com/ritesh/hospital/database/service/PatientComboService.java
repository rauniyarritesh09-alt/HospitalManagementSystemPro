
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PatientComboService {

    public ArrayList<String> getPatients() {

        ArrayList<String> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT patientId, name FROM patients ORDER BY name")) {

            while (rs.next()) {

                list.add(rs.getInt("patientId") + " - " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}