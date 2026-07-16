
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillingService {

    public boolean addBill(Bill bill) {

        String sql = """
                INSERT INTO bills(
                billId,
                patientId,
                doctorId,
                consultationFee,
                medicineCharge,
                testCharge,
                otherCharge,
                totalAmount,
                paymentMode,
                billDate)
                VALUES(?,?,?,?,?,?,?,?,?,?)
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getBillId());
            ps.setInt(2, bill.getPatientId());
            ps.setInt(3, bill.getDoctorId());
            ps.setInt(4, bill.getConsultationFee());
            ps.setInt(5, bill.getMedicineCharge());
            ps.setInt(6, bill.getTestCharge());
            ps.setInt(7, bill.getOtherCharge());
            ps.setInt(8, bill.getTotalAmount());
            ps.setString(9, bill.getPaymentMode());
            ps.setString(10, bill.getBillDate());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}