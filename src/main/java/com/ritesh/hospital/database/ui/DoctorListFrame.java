
package com.ritesh.hospital.database.ui;

import com.ritesh.hospital.database.service.DoctorListService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

public class DoctorListFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    DoctorListService service = new DoctorListService();

    public DoctorListFrame() {

        setTitle("Doctor List");

        setSize(800,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        model = new DefaultTableModel();

        model.addColumn("Doctor ID");
        model.addColumn("Name");
        model.addColumn("Specialization");
        model.addColumn("Qualification");
        model.addColumn("Experience");
        model.addColumn("Mobile");
        model.addColumn("Email");

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);

        loadDoctors();

        setVisible(true);
    }

    private void loadDoctors() {

        try {

            ResultSet rs = service.getAllDoctors();

            while (rs.next()) {

                model.addRow(new Object[]{
                        rs.getInt("doctorId"),
                        rs.getString("name"),
                        rs.getString("specialization"),
                        rs.getString("qualification"),
                        rs.getInt("experience"),
                        rs.getString("mobile"),
                        rs.getString("email")
                });

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}