
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientViewService {

    public void loadPatients(DefaultTableModel model) {

        model.setRowCount(0);

        String sql = "SELECT * FROM patients";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("patientId"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("disease"),
                        rs.getString("mobile"),
                        rs.getString("address")
                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}