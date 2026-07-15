
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AppointmentViewService {

    public void loadAppointments(DefaultTableModel model) {

        model.setRowCount(0);

        String sql = """
                SELECT a.appointmentId,
                       p.name AS patientName,
                       d.name AS doctorName,
                       a.appointmentDate,
                       a.appointmentTime,
                       a.status
                FROM appointments a
                JOIN patients p ON a.patientId = p.patientId
                JOIN doctors d ON a.doctorId = d.doctorId
                ORDER BY a.appointmentId
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("appointmentId"),
                        rs.getString("patientName"),
                        rs.getString("doctorName"),
                        rs.getString("appointmentDate"),
                        rs.getString("appointmentTime"),
                        rs.getString("status")
                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}