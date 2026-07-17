
package com.ritesh.hospital.database.ui;

import com.ritesh.hospital.database.service.ReportService;

import javax.swing.*;

public class ReportFrame extends JFrame {

    ReportService service = new ReportService();

    public ReportFrame() {

        setTitle("Hospital Reports");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("HOSPITAL REPORTS");
        title.setBounds(150,20,250,30);

        JLabel lblPatients = new JLabel("Total Patients : " + service.getCount("patients"));
        lblPatients.setBounds(80,80,300,25);

        JLabel lblDoctors = new JLabel("Total Doctors : " + service.getCount("doctors"));
        lblDoctors.setBounds(80,120,300,25);

        JLabel lblAppointments = new JLabel("Total Appointments : " + service.getCount("appointments"));
        lblAppointments.setBounds(80,160,300,25);

        JLabel lblBills = new JLabel("Total Bills : " + service.getCount("bills"));
        lblBills.setBounds(80,200,300,25);

        JLabel lblRevenue = new JLabel("Total Revenue : ₹ " + service.getTotalRevenue());
        lblRevenue.setBounds(80,240,300,25);

        add(title);
        add(lblPatients);
        add(lblDoctors);
        add(lblAppointments);
        add(lblBills);
        add(lblRevenue);

        setVisible(true);
    }
}