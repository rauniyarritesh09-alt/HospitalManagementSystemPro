
package com.ritesh.hospital.database.ui;

import com.ritesh.hospital.database.service.AppointmentViewService;

import javax.swing.*;
        import javax.swing.table.DefaultTableModel;

public class AppointmentListFrame extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    AppointmentViewService service = new AppointmentViewService();

    public AppointmentListFrame() {

        setTitle("Appointment List");

        setSize(900,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        String[] columns = {
                "Appointment ID",
                "Patient",
                "Doctor",
                "Date",
                "Time",
                "Status"
        };

        model = new DefaultTableModel(columns,0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,20,850,400);

        add(scrollPane);

        service.loadAppointments(model);

        setVisible(true);
    }
}