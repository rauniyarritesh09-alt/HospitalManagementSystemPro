
package com.ritesh.hospital.database.ui;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Hospital Management System - Dashboard");
        setSize(950,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
        title.setBounds(250,30,450,30);

        JButton patient = new JButton("Patient");
        patient.setBounds(50,120,150,50);
        patient.addActionListener(e -> new PatientForm());

        JButton doctor = new JButton("Doctor");
        doctor.setBounds(230,120,150,50);
        doctor.addActionListener(e -> new DoctorForm());

        JButton appointment = new JButton("Appointment");
        appointment.setBounds(410,120,150,50);

        JButton billing = new JButton("Billing");
        billing.setBounds(590,120,150,50);

        JButton searchPatient = new JButton("Search Patient");
        searchPatient.setBounds(50,220,150,50);
        searchPatient.addActionListener(e -> new PatientSearchFrame());

        JButton viewPatients = new JButton("View Patients");
        viewPatients.setBounds(230,220,150,50);
        viewPatients.addActionListener(e -> new PatientListFrame());

        JButton searchDoctor = new JButton("Search Doctor");
        searchDoctor.setBounds(410,220,150,50);
        searchDoctor.addActionListener(e -> new DoctorSearchFrame());

        JButton viewDoctors = new JButton("View Doctors");
        viewDoctors.setBounds(590,220,150,50);
        viewDoctors.addActionListener(e -> new DoctorListFrame());

        JButton logout = new JButton("Logout");
        logout.setBounds(320,330,150,50);
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

        add(logout);

        setVisible(true);
    }
}