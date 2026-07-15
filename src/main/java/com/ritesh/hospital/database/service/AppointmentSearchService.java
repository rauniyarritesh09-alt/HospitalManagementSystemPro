
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentSearchService {

    public Appointment searchAppointment(int appointmentId) {

        String sql = "SELECT * FROM appointments WHERE appointmentId=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Appointment appointment = new Appointment();

                    appointment.setAppointmentId(rs.getInt("appointmentId"));
                    appointment.setPatientId(rs.getInt("patientId"));
                    appointment.setDoctorId(rs.getInt("doctorId"));
                    appointment.setAppointmentDate(rs.getString("appointmentDate"));
                    appointment.setAppointmentTime(rs.getString("appointmentTime"));
                    appointment.setStatus(rs.getString("status"));

                    return appointment;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}