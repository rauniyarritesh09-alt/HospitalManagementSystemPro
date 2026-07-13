
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DoctorUpdateService {

    public boolean updateDoctor(Doctor doctor) {

        String sql = "UPDATE doctors SET name=?, specialization=?, qualification=?, experience=?, mobile=?, email=? WHERE doctorId=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getQualification());
            ps.setInt(4, doctor.getExperience());
            ps.setString(5, doctor.getMobile());
            ps.setString(6, doctor.getEmail());
            ps.setInt(7, doctor.getDoctorId());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}