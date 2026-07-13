
package com.ritesh.hospital.database.ui;

import com.ritesh.hospital.database.model.Doctor;
import com.ritesh.hospital.database.service.DoctorDeleteService;
import com.ritesh.hospital.database.service.DoctorSearchService;
import com.ritesh.hospital.database.service.DoctorUpdateService;

import javax.swing.*;

public class DoctorSearchFrame extends JFrame {

    private JTextField txtDoctorId;
    private JTextField txtName;
    private JTextField txtSpecialization;
    private JTextField txtQualification;
    private JTextField txtExperience;
    private JTextField txtMobile;
    private JTextField txtEmail;

    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnDelete;

    DoctorSearchService searchService = new DoctorSearchService();
    DoctorUpdateService updateService = new DoctorUpdateService();
    DoctorDeleteService deleteService = new DoctorDeleteService();

    public DoctorSearchFrame() {

        setTitle("Search / Update / Delete Doctor");
        setSize(550,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblId = new JLabel("Doctor ID");
        lblId.setBounds(30,30,100,25);

        txtDoctorId = new JTextField();
        txtDoctorId.setBounds(150,30,180,25);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(350,30,100,25);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,80,100,25);

        txtName = new JTextField();
        txtName.setBounds(150,80,250,25);

        JLabel lblSpecialization = new JLabel("Specialization");
        lblSpecialization.setBounds(30,120,100,25);

        txtSpecialization = new JTextField();
        txtSpecialization.setBounds(150,120,250,25);

        JLabel lblQualification = new JLabel("Qualification");
        lblQualification.setBounds(30,160,100,25);

        txtQualification = new JTextField();
        txtQualification.setBounds(150,160,250,25);

        JLabel lblExperience = new JLabel("Experience");
        lblExperience.setBounds(30,200,100,25);

        txtExperience = new JTextField();
        txtExperience.setBounds(150,200,250,25);

        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(30,240,100,25);

        txtMobile = new JTextField();
        txtMobile.setBounds(150,240,250,25);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30,280,100,25);

        txtEmail = new JTextField();
        txtEmail.setBounds(150,280,250,25);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100,360,120,35);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(260,360,120,35);

        // SEARCH
        btnSearch.addActionListener(e -> {

            try {

                int id = Integer.parseInt(txtDoctorId.getText());

                Doctor doctor = searchService.searchDoctor(id);

                if (doctor != null) {

                    txtName.setText(doctor.getName());
                    txtSpecialization.setText(doctor.getSpecialization());
                    txtQualification.setText(doctor.getQualification());
                    txtExperience.setText(String.valueOf(doctor.getExperience()));
                    txtMobile.setText(doctor.getMobile());
                    txtEmail.setText(doctor.getEmail());

                } else {

                    JOptionPane.showMessageDialog(this, "Doctor Not Found");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this, "Invalid Doctor ID");

            }

        });

        // UPDATE
        btnUpdate.addActionListener(e -> {

            try {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(Integer.parseInt(txtDoctorId.getText()));
                doctor.setName(txtName.getText());
                doctor.setSpecialization(txtSpecialization.getText());
                doctor.setQualification(txtQualification.getText());
                doctor.setExperience(Integer.parseInt(txtExperience.getText()));
                doctor.setMobile(txtMobile.getText());
                doctor.setEmail(txtEmail.getText());

                if (updateService.updateDoctor(doctor)) {

                    JOptionPane.showMessageDialog(this,
                            "Doctor Updated Successfully");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Update Failed");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Invalid Data");

            }

        });

        // DELETE
        btnDelete.addActionListener(e -> {

            int id = Integer.parseInt(txtDoctorId.getText());

            int option = JOptionPane.showConfirmDialog(this,
                    "Are you sure to delete?");

            if (option == JOptionPane.YES_OPTION) {

                if (deleteService.deleteDoctor(id)) {

                    JOptionPane.showMessageDialog(this,
                            "Doctor Deleted Successfully");

                    txtDoctorId.setText("");
                    txtName.setText("");
                    txtSpecialization.setText("");
                    txtQualification.setText("");
                    txtExperience.setText("");
                    txtMobile.setText("");
                    txtEmail.setText("");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Delete Failed");

                }
            }

        });

        add(lblId);
        add(txtDoctorId);
        add(btnSearch);

        add(lblName);
        add(txtName);

        add(lblSpecialization);
        add(txtSpecialization);

        add(lblQualification);
        add(txtQualification);

        add(lblExperience);
        add(txtExperience);

        add(lblMobile);
        add(txtMobile);

        add(lblEmail);
        add(txtEmail);

        add(btnUpdate);
        add(btnDelete);

        setVisible(true);
    }
}