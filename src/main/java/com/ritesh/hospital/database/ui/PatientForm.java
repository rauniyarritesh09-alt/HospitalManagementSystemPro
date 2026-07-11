
package com.ritesh.hospital.database.ui;

import com.ritesh.hospital.database.model.Patient;
import com.ritesh.hospital.database.service.PatientService;

import javax.swing.*;

public class PatientForm extends JFrame {

    JTextField txtId, txtName, txtAge, txtDisease, txtMobile, txtAddress;
    JComboBox<String> cmbGender;
    JButton btnSave;

    PatientService service = new PatientService();

    public PatientForm() {

        setTitle("Add Patient");
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblId = new JLabel("Patient ID");
        lblId.setBounds(30,30,100,25);

        txtId = new JTextField();
        txtId.setBounds(150,30,250,25);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,70,100,25);

        txtName = new JTextField();
        txtName.setBounds(150,70,250,25);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(30,110,100,25);

        txtAge = new JTextField();
        txtAge.setBounds(150,110,250,25);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,150,100,25);

        cmbGender = new JComboBox<>(new String[]{"Male","Female","Other"});
        cmbGender.setBounds(150,150,250,25);

        JLabel lblDisease = new JLabel("Disease");
        lblDisease.setBounds(30,190,100,25);

        txtDisease = new JTextField();
        txtDisease.setBounds(150,190,250,25);

        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(30,230,100,25);

        txtMobile = new JTextField();
        txtMobile.setBounds(150,230,250,25);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30,270,100,25);

        txtAddress = new JTextField();
        txtAddress.setBounds(150,270,250,25);

        btnSave = new JButton("Save Patient");
        btnSave.setBounds(150,330,150,35);

        btnSave.addActionListener(e -> {

            try {

                Patient patient = new Patient();

                patient.setPatientId(Integer.parseInt(txtId.getText()));
                patient.setName(txtName.getText());
                patient.setAge(Integer.parseInt(txtAge.getText()));
                patient.setGender(cmbGender.getSelectedItem().toString());
                patient.setDisease(txtDisease.getText());
                patient.setMobile(txtMobile.getText());
                patient.setAddress(txtAddress.getText());

                if(service.addPatient(patient)){

                    JOptionPane.showMessageDialog(this,
                            "Patient Added Successfully!");

                    txtId.setText("");
                    txtName.setText("");
                    txtAge.setText("");
                    txtDisease.setText("");
                    txtMobile.setText("");
                    txtAddress.setText("");

                }else{

                    JOptionPane.showMessageDialog(this,
                            "Failed to Add Patient");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Data");

            }

        });

        add(lblId);
        add(txtId);

        add(lblName);
        add(txtName);

        add(lblAge);
        add(txtAge);

        add(lblGender);
        add(cmbGender);

        add(lblDisease);
        add(txtDisease);

        add(lblMobile);
        add(txtMobile);

        add(lblAddress);
        add(txtAddress);

        add(btnSave);

        setVisible(true);
    }
}