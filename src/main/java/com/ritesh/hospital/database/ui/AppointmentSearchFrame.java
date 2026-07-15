
package com.ritesh.hospital.database.ui;

import com.github.lgooddatepicker.components.DatePicker;
import com.ritesh.hospital.database.service.*;

        import javax.swing.*;
import com.ritesh.hospital.database.model.Appointment;

public class AppointmentSearchFrame extends JFrame {

    private JTextField txtAppointmentId;

    private JComboBox<String> cmbPatient;
    private JComboBox<String> cmbDoctor;
    private JComboBox<String> cmbTime;
    private JComboBox<String> cmbStatus;

    private DatePicker datePicker;

    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnDelete;

    PatientComboService patientService = new PatientComboService();
    DoctorComboService doctorService = new DoctorComboService();

    AppointmentSearchService searchService = new AppointmentSearchService();
    AppointmentUpdateService updateService = new AppointmentUpdateService();
    AppointmentDeleteService deleteService = new AppointmentDeleteService();

    public AppointmentSearchFrame() {

        setTitle("Search Appointment");

        setSize(650,550);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblId = new JLabel("Appointment ID");
        lblId.setBounds(30,30,120,25);

        txtAppointmentId = new JTextField();
        txtAppointmentId.setBounds(170,30,220,25);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(420,30,120,25);

        JLabel lblPatient = new JLabel("Patient");
        lblPatient.setBounds(30,80,120,25);

        cmbPatient = new JComboBox<>();
        cmbPatient.setBounds(170,80,350,25);

        JLabel lblDoctor = new JLabel("Doctor");
        lblDoctor.setBounds(30,130,120,25);

        cmbDoctor = new JComboBox<>();
        cmbDoctor.setBounds(170,130,350,25);

        JLabel lblDate = new JLabel("Appointment Date");
        lblDate.setBounds(30,180,120,25);

        datePicker = new DatePicker();
        datePicker.setBounds(170,180,220,30);

        JLabel lblTime = new JLabel("Appointment Time");
        lblTime.setBounds(30,230,120,25);

        cmbTime = new JComboBox<>();
        cmbTime.setBounds(170,230,220,25);

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setBounds(30,280,120,25);

        cmbStatus = new JComboBox<>();
        cmbStatus.setBounds(170,280,220,25);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(170,360,120,40);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(320,360,120,40);

        add(lblId);
        add(txtAppointmentId);
        add(btnSearch);

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

        add(btnUpdate);
        add(btnDelete);

        // Load Patients
        for (String patient : patientService.getPatients()) {
            cmbPatient.addItem(patient);
        }

        // Load Doctors
        for (String doctor : doctorService.getDoctors()) {
            cmbDoctor.addItem(doctor);
        }

        // Time
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
        btnSearch.addActionListener(e -> {

            try {

                int id = Integer.parseInt(txtAppointmentId.getText());

                var appointment = searchService.searchAppointment(id);

                if (appointment != null) {

                    // Patient Select
                    for (int i = 0; i < cmbPatient.getItemCount(); i++) {

                        if (cmbPatient.getItemAt(i).startsWith(
                                appointment.getPatientId() + " -")) {

                            cmbPatient.setSelectedIndex(i);
                            break;
                        }
                    }

                    // Doctor Select
                    for (int i = 0; i < cmbDoctor.getItemCount(); i++) {

                        if (cmbDoctor.getItemAt(i).startsWith(
                                appointment.getDoctorId() + " -")) {

                            cmbDoctor.setSelectedIndex(i);
                            break;
                        }
                    }

                    // Date
                    datePicker.setDate(
                            java.time.LocalDate.parse(
                                    appointment.getAppointmentDate()));

                    // Time
                    cmbTime.setSelectedItem(
                            appointment.getAppointmentTime());

                    // Status
                    cmbStatus.setSelectedItem(
                            appointment.getStatus());

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Appointment Not Found");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please Enter Valid Appointment ID");


            }

        });

        btnUpdate.addActionListener(e -> {

            try {

                Appointment appointment = new Appointment();

                appointment.setAppointmentId(
                        Integer.parseInt(txtAppointmentId.getText()));

                // Patient ID
                String patient = cmbPatient.getSelectedItem().toString();
                int patientId = Integer.parseInt(patient.split(" - ")[0]);
                appointment.setPatientId(patientId);

                // Doctor ID
                String doctor = cmbDoctor.getSelectedItem().toString();
                int doctorId = Integer.parseInt(doctor.split(" - ")[0]);
                appointment.setDoctorId(doctorId);

                // Date
                appointment.setAppointmentDate(datePicker.getDate().toString());

                // Time
                appointment.setAppointmentTime(
                        cmbTime.getSelectedItem().toString());

                // Status
                appointment.setStatus(
                        cmbStatus.getSelectedItem().toString());

                if (updateService.updateAppointment(appointment)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Appointment Updated Successfully!");

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Update Failed!");

                }

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Please Enter Valid Data");

            }

        });

        btnDelete.addActionListener(e -> {

            try {

                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this appointment?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {

                    int id = Integer.parseInt(txtAppointmentId.getText());

                    if (deleteService.deleteAppointment(id)) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Appointment Deleted Successfully!");

                        txtAppointmentId.setText("");
                        datePicker.clear();

                        if (cmbPatient.getItemCount() > 0) {
                            cmbPatient.setSelectedIndex(0);
                        }

                        if (cmbDoctor.getItemCount() > 0) {
                            cmbDoctor.setSelectedIndex(0);
                        }

                        if (cmbTime.getItemCount() > 0) {
                            cmbTime.setSelectedIndex(0);
                        }

                        if (cmbStatus.getItemCount() > 0) {
                            cmbStatus.setSelectedIndex(0);
                        }

                    } else {

                        JOptionPane.showMessageDialog(
                                this,
                                "Appointment Not Found!");

                    }
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please Enter Valid Appointment ID");

            }

        });


        setVisible(true);
    }
}