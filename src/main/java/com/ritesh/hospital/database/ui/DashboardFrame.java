
package com.ritesh.hospital.database.ui;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Hospital Management System - Dashboard");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
        title.setBounds(250, 20, 400, 30);

        // ===== Row 1 =====

        JButton patient = new JButton("Patient");
        patient.setBounds(50, 80, 170, 50);
        patient.addActionListener(e -> new PatientForm());

        JButton doctor = new JButton("Doctor");
        doctor.setBounds(250, 80, 170, 50);
        doctor.addActionListener(e -> new DoctorForm());

        JButton appointment = new JButton("Appointment");
        appointment.setBounds(450, 80, 170, 50);
        appointment.addActionListener(e -> new AppointmentForm());

        JButton billing = new JButton("Billing");
        billing.setBounds(650, 80, 170, 50);

        // ===== Row 2 =====

        JButton searchPatient = new JButton("Search Patient");
        searchPatient.setBounds(50, 170, 170, 50);
        searchPatient.addActionListener(e -> new PatientSearchFrame());

        JButton viewPatients = new JButton("View Patients");
        viewPatients.setBounds(250, 170, 170, 50);
        viewPatients.addActionListener(e -> new PatientListFrame());

        JButton searchDoctor = new JButton("Search Doctor");
        searchDoctor.setBounds(450, 170, 170, 50);
        searchDoctor.addActionListener(e -> new DoctorSearchFrame());

        JButton viewDoctors = new JButton("View Doctors");
        viewDoctors.setBounds(650, 170, 170, 50);
        viewDoctors.addActionListener(e -> new DoctorListFrame());

        // ===== Row 3 =====

        JButton searchAppointment = new JButton("Search Appointment");
        searchAppointment.setBounds(50, 260, 170, 50);
        searchAppointment.addActionListener(e -> new AppointmentSearchFrame());

        JButton viewAppointments = new JButton("View Appointments");
        viewAppointments.setBounds(250, 260, 170, 50);
        viewAppointments.addActionListener(e -> new AppointmentListFrame());

        JButton reports = new JButton("Reports");
        reports.setBounds(450, 260, 170, 50);

        JButton logout = new JButton("Logout");
        logout.setBounds(650, 260, 170, 50);
        logout.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

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
        add(reports);
        add(logout);

        setVisible(true);
    }
}