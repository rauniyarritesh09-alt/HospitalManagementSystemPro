
package com.ritesh.hospital.database.service;

import com.ritesh.hospital.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DashboardService {

    private int getCount(String tableName) {

        String sql = "SELECT COUNT(*) FROM " + tableName;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getTotalPatients() {
        return getCount("patients");
    }

    public int getTotalDoctors() {
        return getCount("doctors");
    }

    public int getTotalAppointments() {
        return getCount("appointments");
    }

    public int getTotalBills() {
        return getCount("bills");
    }

    public int getTotalRevenue() {

        String sql = "SELECT IFNULL(SUM(totalAmount),0) FROM bills";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}