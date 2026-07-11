
package com.ritesh.hospital.database.ui;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Hospital Management System - Dashboard");

        setSize(800,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
        title.setBounds(180,30,450,30);

        JButton patient = new JButton("Patient");
        patient.addActionListener(e -> {

            new PatientForm();


        });
        JButton viewPatients = new JButton("View Patients");

        viewPatients.addActionListener(e -> {

            new PatientListFrame();

        });



        JButton doctor = new JButton("Doctor");
        JButton searchPatient = new JButton("Search Patient");
        searchPatient.setBounds(580,120,150,50);
        searchPatient.addActionListener(e -> {

            new PatientSearchFrame();

        });

        add(searchPatient);


        JButton appointment = new JButton("Appointment");

        JButton billing = new JButton("Billing");


        JButton logout = new JButton("Logout");

        patient.setBounds(80,120,150,50);

        doctor.setBounds(280,120,150,50);

        appointment.setBounds(450 ,120,150,50);

        billing.setBounds(180,230,150,50);

        viewPatients.setBounds(580,230,150,50);


        logout.setBounds(380,230,150,50);

        add(title);

        add(patient);

        add(doctor);

        add(appointment);

        add(billing);
        add(viewPatients);

        add(logout);

        setVisible(true);

    }

}