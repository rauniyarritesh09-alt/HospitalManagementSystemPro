
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientUpdateService {

    public boolean updatePatient(Patient patient) {

        String sql = """
                UPDATE patients
                SET name=?, age=?, gender=?, disease=?, mobile=?, address=?
                WHERE patientId=?
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getDisease());
            ps.setString(5, patient.getMobile());
            ps.setString(6, patient.getAddress());
            ps.setInt(7, patient.getPatientId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}