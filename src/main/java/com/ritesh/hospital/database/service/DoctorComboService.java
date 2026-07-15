
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DoctorComboService {

    public ArrayList<String> getDoctors() {

        ArrayList<String> list = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT doctorId, name, specialization FROM doctors ORDER BY name")) {

            while (rs.next()) {

                String doctor = rs.getInt("doctorId")
                        + " - Dr. "
                        + rs.getString("name")
                        + " ("
                        + rs.getString("specialization")
                        + ")";

                list.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}