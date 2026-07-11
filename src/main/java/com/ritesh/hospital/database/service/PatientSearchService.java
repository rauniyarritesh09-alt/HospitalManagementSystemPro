
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientSearchService {

    public Patient searchPatient(int patientId) {

        String sql = "SELECT * FROM patients WHERE patientId=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Patient patient = new Patient();

                    patient.setPatientId(rs.getInt("patientId"));
                    patient.setName(rs.getString("name"));
                    patient.setAge(rs.getInt("age"));
                    patient.setGender(rs.getString("gender"));
                    patient.setDisease(rs.getString("disease"));
                    patient.setMobile(rs.getString("mobile"));
                    patient.setAddress(rs.getString("address"));

                    return patient;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}