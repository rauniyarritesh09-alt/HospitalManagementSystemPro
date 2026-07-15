
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentService {

    public boolean addAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointments(appointmentId, patientId, doctorId, appointmentDate, appointmentTime, status) VALUES(?,?,?,?,?,?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getAppointmentId());
            ps.setInt(2, appointment.getPatientId());
            ps.setInt(3, appointment.getDoctorId());
            ps.setString(4, appointment.getAppointmentDate());
            ps.setString(5, appointment.getAppointmentTime());
            ps.setString(6, appointment.getStatus());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}