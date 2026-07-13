
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorSearchService {

    public Doctor searchDoctor(int doctorId) {

        String sql = "SELECT * FROM doctors WHERE doctorId=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctorId"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setQualification(rs.getString("qualification"));
                doctor.setExperience(rs.getInt("experience"));
                doctor.setMobile(rs.getString("mobile"));
                doctor.setEmail(rs.getString("email"));

                return doctor;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}