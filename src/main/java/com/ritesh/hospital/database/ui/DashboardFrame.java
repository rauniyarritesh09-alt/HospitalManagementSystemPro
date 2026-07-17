
package com.ritesh.hospital.database.ui;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {

        setTitle("Hospital Management System - Dashboard");
        setSize(950, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        JLabel title = new JLabel("WELCOME TO HOSPITAL MANAGEMENT SYSTEM");
        title.setBounds(180, 20, 600, 35);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        // ================= PATIENT =================

        JButton patient = new JButton("Patient", loadIcon("patient.png"));
        patient.setBounds(50,80,180,50);
        styleButton(patient);
        patient.addActionListener(e -> new PatientForm());

        JButton searchPatient = new JButton("Search Patient", loadIcon("search.png"));
        searchPatient.setBounds(50,150,180,50);
        styleButton(searchPatient);
        searchPatient.addActionListener(e -> new PatientSearchFrame());

        JButton viewPatients = new JButton("View Patients", loadIcon("view.png"));
        viewPatients.setBounds(50,220,180,50);
        styleButton(viewPatients);
        viewPatients.addActionListener(e -> new PatientListFrame());

        // ================= DOCTOR =================

        JButton doctor = new JButton("Doctor", loadIcon("doctor.png"));
        doctor.setBounds(270,80,180,50);
        styleButton(doctor);
        doctor.addActionListener(e -> new DoctorForm());

        JButton searchDoctor = new JButton("Search Doctor", loadIcon("search.png"));
        searchDoctor.setBounds(270,150,180,50);
        styleButton(searchDoctor);
        searchDoctor.addActionListener(e -> new DoctorSearchFrame());

        JButton viewDoctors = new JButton("View Doctors", loadIcon("view.png"));
        viewDoctors.setBounds(270,220,180,50);
        styleButton(viewDoctors);
        viewDoctors.addActionListener(e -> new DoctorListFrame());

        // ================= APPOINTMENT =================

        JButton appointment = new JButton("Appointment", loadIcon("appointment.png"));
        appointment.setBounds(490,80,180,50);
        styleButton(appointment);
        appointment.addActionListener(e -> new AppointmentForm());

        JButton searchAppointment = new JButton("Search Appointment", loadIcon("search.png"));
        searchAppointment.setBounds(490,150,180,50);
        styleButton(searchAppointment);
        searchAppointment.addActionListener(e -> new AppointmentSearchFrame());

        JButton viewAppointments = new JButton("View Appointments", loadIcon("view.png"));
        viewAppointments.setBounds(490,220,180,50);
        styleButton(viewAppointments);
        viewAppointments.addActionListener(e -> new AppointmentListFrame());

        // ================= BILLING =================

        JButton billing = new JButton("Billing", loadIcon("bill.png"));
        billing.setBounds(710,80,180,50);
        styleButton(billing);
        billing.addActionListener(e -> new BillingForm());

        JButton searchBill = new JButton("Search Bill", loadIcon("search.png"));
        searchBill.setBounds(710,150,180,50);
        styleButton(searchBill);
        searchBill.addActionListener(e -> new BillSearchFrame());

        JButton viewBills = new JButton("View Bills", loadIcon("view.png"));
        viewBills.setBounds(710,220,180,50);
        styleButton(viewBills);
        viewBills.addActionListener(e -> new BillListFrame());

        // ================= BOTTOM =================

        JButton reports = new JButton("Reports", loadIcon("report.png"));
        reports.setBounds(270,330,180,50);
        styleButton(reports);
        reports.addActionListener(e -> new ReportFrame());

        JButton logout = new JButton("Logout", loadIcon("log-out.png"));
        logout.setBounds(490,330,180,50);
        styleButton(logout);
        logout.addActionListener(e -> {
            dispose();
            new LoginFrame();
        });

        // ================= ADD =================

        add(title);

        add(patient);
        add(searchPatient);
        add(viewPatients);

        add(doctor);
        add(searchDoctor);
        add(viewDoctors);

        add(appointment);
        add(searchAppointment);
        add(viewAppointments);

        add(billing);
        add(searchBill);
        add(viewBills);

        add(reports);
        add(logout);

        setVisible(true);
    }

    // ================= ICON =================

    private ImageIcon loadIcon(String name) {

        java.net.URL url = getClass().getResource("/icons/" + name);

        if (url != null) {

            ImageIcon icon = new ImageIcon(url);

            Image img = icon.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);

            return new ImageIcon(img);
        }

        return null;
    }

    // ================= BUTTON STYLE =================

    private void styleButton(JButton button){

        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setHorizontalTextPosition(SwingConstants.RIGHT);

        button.setIconTextGap(12);

        button.setFont(new Font("Arial",Font.BOLD,14));

        button.setFocusable(false);
    }
}