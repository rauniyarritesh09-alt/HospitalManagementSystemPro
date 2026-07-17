
package com.ritesh.hospital.database.ui;

import com.github.lgooddatepicker.components.DatePicker;
import com.ritesh.hospital.database.service.DoctorComboService;
import com.ritesh.hospital.database.service.PatientComboService;
import com.ritesh.hospital.database.model.Appointment;
import com.ritesh.hospital.database.service.AppointmentService;

import javax.swing.*;
import com.ritesh.hospital.database.pdf.AppointmentPDFGenerator;

public class AppointmentForm extends JFrame {

    private JTextField txtAppointmentId;

    private JComboBox<String> cmbPatient;
    private JComboBox<String> cmbDoctor;
    private JComboBox<String> cmbTime;
    private JComboBox<String> cmbStatus;

    private DatePicker datePicker;

    private JButton btnSave;
    private JButton btnExportPDF;

    PatientComboService patientService = new PatientComboService();
    DoctorComboService doctorService = new DoctorComboService();
    AppointmentService appointmentService = new AppointmentService();

    public AppointmentForm() {

        setTitle("Appointment Management");

        setSize(600,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblTitle = new JLabel("APPOINTMENT MANAGEMENT");
        lblTitle.setBounds(170,20,250,30);

        JLabel lblId = new JLabel("Appointment ID");
        lblId.setBounds(40,70,120,25);

        txtAppointmentId = new JTextField();
        txtAppointmentId.setBounds(180,70,250,25);

        JLabel lblPatient = new JLabel("Patient");
        lblPatient.setBounds(40,110,120,25);

        cmbPatient = new JComboBox<>();
        cmbPatient.setBounds(180,110,300,25);

        JLabel lblDoctor = new JLabel("Doctor");
        lblDoctor.setBounds(40,150,120,25);

        cmbDoctor = new JComboBox<>();
        cmbDoctor.setBounds(180,150,300,25);

        JLabel lblDate = new JLabel("Appointment Date");
        lblDate.setBounds(40,190,120,25);

        datePicker = new DatePicker();
        datePicker.setBounds(180,190,200,30);

        JLabel lblTime = new JLabel("Appointment Time");
        lblTime.setBounds(40,240,120,25);

        cmbTime = new JComboBox<>();
        cmbTime.setBounds(180,240,200,25);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(40,290,120,25);

        cmbStatus = new JComboBox<>();
        cmbStatus.setBounds(180,290,200,25);

        btnSave = new JButton("Save Appointment");
        btnSave.setBounds(180,360,180,40);
        btnExportPDF = new JButton("Export PDF");
        btnExportPDF.setBounds(380,360,150,40);

        add(lblTitle);

        add(lblId);
        add(txtAppointmentId);

        add(lblPatient);
        add(cmbPatient);

        add(lblDoctor);
        add(cmbDoctor);

        add(lblDate);
        add(datePicker);

        add(lblTime);
        add(cmbTime);

        add(lblStatus);
        add(cmbStatus);

        add(btnSave);
        add(btnExportPDF);
        // Load Patients
        for (String patient : patientService.getPatients()) {
            cmbPatient.addItem(patient);
        }

// Load Doctors
        for (String doctor : doctorService.getDoctors()) {
            cmbDoctor.addItem(doctor);
        }

// Time Slots
        cmbTime.addItem("09:00 AM");
        cmbTime.addItem("09:30 AM");
        cmbTime.addItem("10:00 AM");
        cmbTime.addItem("10:30 AM");
        cmbTime.addItem("11:00 AM");
        cmbTime.addItem("11:30 AM");
        cmbTime.addItem("12:00 PM");
        cmbTime.addItem("02:00 PM");
        cmbTime.addItem("02:30 PM");
        cmbTime.addItem("03:00 PM");
        cmbTime.addItem("03:30 PM");
        cmbTime.addItem("04:00 PM");
        cmbTime.addItem("04:30 PM");
        cmbTime.addItem("05:00 PM");

// Status
        cmbStatus.addItem("Scheduled");
        cmbStatus.addItem("Completed");
        cmbStatus.addItem("Cancelled");

        btnSave.addActionListener(e -> {

            try {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(
                        Integer.parseInt(txtAppointmentId.getText()));

                // Patient ID
                String patient = cmbPatient.getSelectedItem().toString();
                appointment.setPatientId(
                        Integer.parseInt(patient.split(" - ")[0]));
                appointment.setPatientName(patient.split(" - ", 2)[1]);

                String doctor = cmbDoctor.getSelectedItem().toString();
                appointment.setDoctorId(
                        Integer.parseInt(doctor.split(" - ")[0]));
                appointment.setDoctorName(doctor.split(" - ", 2)[1]);
                // Date
                appointment.setAppointmentDate(datePicker.getDate().toString());

                // Time
                appointment.setAppointmentTime(
                        cmbTime.getSelectedItem().toString());

                // Status
                appointment.setStatus(
                        cmbStatus.getSelectedItem().toString());

                if (appointmentService.addAppointment(appointment)) {

                    JOptionPane.showMessageDialog(this,
                            "Appointment Saved Successfully");

                    txtAppointmentId.setText("");
                    datePicker.clear();

                    cmbPatient.setSelectedIndex(0);
                    cmbDoctor.setSelectedIndex(0);
                    cmbTime.setSelectedIndex(0);
                    cmbStatus.setSelectedIndex(0);

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Failed to Save Appointment");

                }

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Data");

            }

        });

        btnExportPDF.addActionListener(e -> {

            try {

                if (txtAppointmentId.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Please Enter Appointment Details First!");
                    return;
                }

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(
                        Integer.parseInt(txtAppointmentId.getText()));
                String patient = cmbPatient.getSelectedItem().toString();
                appointment.setPatientId(
                        Integer.parseInt(patient.split(" - ")[0]));
                appointment.setPatientName(patient.split(" - ")[1]);

                String doctor = cmbDoctor.getSelectedItem().toString();
                appointment.setDoctorId(
                        Integer.parseInt(doctor.split(" - ")[0]));
                appointment.setDoctorName(doctor.split(" - ")[1]);




                if (datePicker.getDate() == null) {
                    JOptionPane.showMessageDialog(this,
                            "Please Select Appointment Date!");
                    return;
                }

                appointment.setAppointmentDate(datePicker.getDate().toString());
                appointment.setAppointmentTime(cmbTime.getSelectedItem().toString());
                appointment.setStatus(cmbStatus.getSelectedItem().toString());

                AppointmentPDFGenerator pdf = new AppointmentPDFGenerator();
                pdf.generatePDF(appointment);

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(this,
                        "Please Fill All Fields Correctly!");

            }

        });

        setVisible(true);
    }
}