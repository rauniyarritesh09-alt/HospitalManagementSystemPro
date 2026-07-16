
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BillSearchService {

    public Bill searchBill(int billId) {

        String sql = "SELECT * FROM bills WHERE billId=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Bill bill = new Bill();

                    bill.setBillId(rs.getInt("billId"));
                    bill.setPatientId(rs.getInt("patientId"));
                    bill.setDoctorId(rs.getInt("doctorId"));
                    bill.setConsultationFee(rs.getInt("consultationFee"));
                    bill.setMedicineCharge(rs.getInt("medicineCharge"));
                    bill.setTestCharge(rs.getInt("testCharge"));
                    bill.setOtherCharge(rs.getInt("otherCharge"));
                    bill.setTotalAmount(rs.getInt("totalAmount"));
                    bill.setPaymentMode(rs.getString("paymentMode"));
                    bill.setBillDate(rs.getString("billDate"));

                    return bill;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}