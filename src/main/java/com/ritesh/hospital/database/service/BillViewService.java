
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BillViewService {

    public void loadBills(DefaultTableModel model) {

        model.setRowCount(0);

        String sql = "SELECT * FROM bills";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("billId"),
                        rs.getInt("patientId"),
                        rs.getInt("doctorId"),
                        rs.getInt("consultationFee"),
                        rs.getInt("medicineCharge"),
                        rs.getInt("testCharge"),
                        rs.getInt("otherCharge"),
                        rs.getInt("totalAmount"),
                        rs.getString("paymentMode"),
                        rs.getString("billDate")
                });

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}