
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DoctorService {

    public boolean addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctors(doctorId,name,specialization,qualification,experience,mobile,email) VALUES(?,?,?,?,?,?,?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctor.getDoctorId());
            ps.setString(2, doctor.getName());
            ps.setString(3, doctor.getSpecialization());
            ps.setString(4, doctor.getQualification());
            ps.setInt(5, doctor.getExperience());
            ps.setString(6, doctor.getMobile());
            ps.setString(7, doctor.getEmail());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}