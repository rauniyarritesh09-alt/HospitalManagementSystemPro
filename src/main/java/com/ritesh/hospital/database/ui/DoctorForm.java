
package com.ritesh.hospital.database.ui;

import javax.swing.*;

import com.ritesh.hospital.database.model.Doctor;
import com.ritesh.hospital.database.service.DoctorService;
public class DoctorForm extends JFrame {
    DoctorService service = new DoctorService();

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtSpecialization;
    private JTextField txtQualification;
    private JTextField txtExperience;
    private JTextField txtMobile;
    private JTextField txtEmail;

    private JButton btnSave;

    public DoctorForm() {

        setTitle("Add Doctor");

        setSize(550,550);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        JLabel lblId = new JLabel("Doctor ID");
        lblId.setBounds(30,30,120,25);

        txtId = new JTextField();
        txtId.setBounds(180,30,250,25);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,70,120,25);

        JTextField txtName = new JTextField();
        txtName.setBounds(180,70,250,25);

        JLabel lblSpecialization = new JLabel("Specialization");
        lblSpecialization.setBounds(30,110,120,25);

        JTextField txtSpecialization = new JTextField();
        txtSpecialization.setBounds(180,110,250,25);

        JLabel lblQualification = new JLabel("Qualification");
        lblQualification.setBounds(30,150,120,25);

        JTextField txtQualification = new JTextField();
        txtQualification.setBounds(180,150,250,25);

        JLabel lblExperience = new JLabel("Experience");
        lblExperience.setBounds(30,190,120,25);

        JTextField txtExperience = new JTextField();
        txtExperience.setBounds(180,190,250,25);

        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(30,230,120,25);

        JTextField txtMobile = new JTextField();
        txtMobile.setBounds(180,230,250,25);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30,270,120,25);

        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(180,270,250,25);

        JButton btnSave = new JButton("Save Doctor");
        btnSave.setBounds(180,340,150,35);
        btnSave.addActionListener(e -> {

            try {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(Integer.parseInt(txtId.getText()));
                doctor.setName(txtName.getText());
                doctor.setSpecialization(txtSpecialization.getText());
                doctor.setQualification(txtQualification.getText());
                doctor.setExperience(Integer.parseInt(txtExperience.getText()));
                doctor.setMobile(txtMobile.getText());
                doctor.setEmail(txtEmail.getText());

                if (service.addDoctor(doctor)) {

                    JOptionPane.showMessageDialog(this,
                            "Doctor Added Successfully!");

                    txtId.setText("");
                    txtName.setText("");
                    txtSpecialization.setText("");
                    txtQualification.setText("");
                    txtExperience.setText("");
                    txtMobile.setText("");
                    txtEmail.setText("");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Failed to Add Doctor");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Data");

                ex.printStackTrace();

            }

        });

        add(lblId);
        add(txtId);

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

        add(btnSave);

        setVisible(true);
    }
}