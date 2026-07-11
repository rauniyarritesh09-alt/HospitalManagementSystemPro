
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientService {

    public boolean addPatient(Patient patient) {

        String sql = "INSERT INTO patients(patientId,name,age,gender,disease,mobile,address) VALUES(?,?,?,?,?,?,?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patient.getPatientId());
            ps.setString(2, patient.getName());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getDisease());
            ps.setString(6, patient.getMobile());
            ps.setString(7, patient.getAddress());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}