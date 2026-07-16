
package com.ritesh.hospital.database.ui;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Hospital Management System - Dashboard");
        setSize(950, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
        title.setBounds(220, 20, 500, 35);
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));

        // ================= Row 1 =================

        JButton patient = new JButton("Patient");
        patient.setBounds(50, 80, 180, 50);
        patient.addActionListener(e -> new PatientForm());

        JButton doctor = new JButton("Doctor");
        doctor.setBounds(270, 80, 180, 50);
        doctor.addActionListener(e -> new DoctorForm());

        JButton appointment = new JButton("Appointment");
        appointment.setBounds(490, 80, 180, 50);
        appointment.addActionListener(e -> new AppointmentForm());

        JButton billing = new JButton("Billing");
        billing.setBounds(710, 80, 180, 50);
        billing.addActionListener(e -> new BillingForm());

        // ================= Row 2 =================

        JButton searchPatient = new JButton("Search Patient");
        searchPatient.setBounds(50, 170, 180, 50);
        searchPatient.addActionListener(e -> new PatientSearchFrame());

        JButton viewPatients = new JButton("View Patients");
        viewPatients.setBounds(270, 170, 180, 50);
        viewPatients.addActionListener(e -> new PatientListFrame());

        JButton searchDoctor = new JButton("Search Doctor");
        searchDoctor.setBounds(490, 170, 180, 50);
        searchDoctor.addActionListener(e -> new DoctorSearchFrame());

        JButton viewDoctors = new JButton("View Doctors");
        viewDoctors.setBounds(710, 170, 180, 50);
        viewDoctors.addActionListener(e -> new DoctorListFrame());

        // ================= Row 3 =================

        JButton searchAppointment = new JButton("Search Appointment");
        searchAppointment.setBounds(50, 260, 180, 50);
        searchAppointment.addActionListener(e -> new AppointmentSearchFrame());

        JButton viewAppointments = new JButton("View Appointments");
        viewAppointments.setBounds(270, 260, 180, 50);
        viewAppointments.addActionListener(e -> new AppointmentListFrame());

        JButton searchBill = new JButton("Search Bill");
        searchBill.setBounds(490, 260, 180, 50);
        searchBill.addActionListener(e -> new BillSearchFrame());

        JButton viewBills = new JButton("View Bills");
        viewBills.setBounds(710, 260, 180, 50);
        viewBills.addActionListener(e -> new BillListFrame());

        // ================= Row 4 =================

        JButton reports = new JButton("Reports");
        reports.setBounds(270, 350, 180, 50);
        // reports.addActionListener(e -> new ReportFrame());

        JButton logout = new JButton("Logout");
        logout.setBounds(490, 350, 180, 50);
        logout.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        // ================= Add Components =================

        add(title);

        add(patient);
        add(doctor);
        add(appointment);
        add(billing);

        add(searchPatient);
        add(viewPatients);
        add(searchDoctor);
        add(viewDoctors);

        add(searchAppointment);
        add(viewAppointments);
        add(searchBill);
        add(viewBills);

        add(reports);
        add(logout);

        setResizable(false);
        setVisible(true);
    }
}