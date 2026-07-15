
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentUpdateService {

    public boolean updateAppointment(Appointment appointment) {

        String sql = """
                UPDATE appointments
                SET patientId=?,
                    doctorId=?,
                    appointmentDate=?,
                    appointmentTime=?,
                    status=?
                WHERE appointmentId=?
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getAppointmentTime());
            ps.setString(5, appointment.getStatus());
            ps.setInt(6, appointment.getAppointmentId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}