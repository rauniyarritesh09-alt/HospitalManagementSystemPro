
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;
import com.ritesh.hospital.database.model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillUpdateService {

    public boolean updateBill(Bill bill) {

        String sql = """
                UPDATE bills
                SET patientId=?,
                    doctorId=?,
                    consultationFee=?,
                    medicineCharge=?,
                    testCharge=?,
                    otherCharge=?,
                    totalAmount=?,
                    paymentMode=?,
                    billDate=?
                WHERE billId=?
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getPatientId());
            ps.setInt(2, bill.getDoctorId());
            ps.setInt(3, bill.getConsultationFee());
            ps.setInt(4, bill.getMedicineCharge());
            ps.setInt(5, bill.getTestCharge());
            ps.setInt(6, bill.getOtherCharge());
            ps.setInt(7, bill.getTotalAmount());
            ps.setString(8, bill.getPaymentMode());
            ps.setString(9, bill.getBillDate());
            ps.setInt(10, bill.getBillId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}