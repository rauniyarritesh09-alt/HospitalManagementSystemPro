
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentDeleteService {

    public boolean deleteAppointment(int appointmentId) {

        String sql = "DELETE FROM appointments WHERE appointmentId=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}