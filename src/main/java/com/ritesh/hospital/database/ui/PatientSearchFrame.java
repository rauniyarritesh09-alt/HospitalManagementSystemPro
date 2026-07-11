
package com.ritesh.hospital.database.ui;
import com.ritesh.hospital.database.model.Patient;
import com.ritesh.hospital.database.service.PatientSearchService;
import com.ritesh.hospital.database.service.PatientUpdateService;
import com.ritesh.hospital.database.service.PatientDeleteService;

import javax.swing.*;

public class PatientSearchFrame extends JFrame {
    PatientSearchService service = new PatientSearchService();
    PatientUpdateService updateService = new PatientUpdateService();
    PatientDeleteService deleteService = new PatientDeleteService();
    private JTextField txtPatientId;
    private JTextField txtName;
    private JTextField txtAge;
    private JTextField txtGender;
    private JTextField txtDisease;
    private JTextField txtMobile;
    private JTextField txtAddress;

    private JButton btnSearch;

    private JButton btnUpdate;

    private JButton btnDelete;

    public PatientSearchFrame() {

        setTitle("Search Patient");

        setSize(500,450);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);
        JLabel lblId = new JLabel("Patient ID");
        lblId.setBounds(30,30,100,25);

        txtPatientId = new JTextField();
        txtPatientId.setBounds(150,30,200,25);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(360,30,90,25);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(180,340,120,35);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(320,340,120,35);

        btnSearch.addActionListener(e -> {

            try {

                int id = Integer.parseInt(txtPatientId.getText());

                Patient patient = service.searchPatient(id);

                if (patient != null) {

                    txtName.setText(patient.getName());
                    txtAge.setText(String.valueOf(patient.getAge()));
                    txtGender.setText(patient.getGender());
                    txtDisease.setText(patient.getDisease());
                    txtMobile.setText(patient.getMobile());
                    txtAddress.setText(patient.getAddress());

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Patient Not Found");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Patient ID");

            }

        });
        btnUpdate.addActionListener(e -> {

            try {

                Patient patient = new Patient();

                patient.setPatientId(Integer.parseInt(txtPatientId.getText()));
                patient.setName(txtName.getText());
                patient.setAge(Integer.parseInt(txtAge.getText()));
                patient.setGender(txtGender.getText());
                patient.setDisease(txtDisease.getText());
                patient.setMobile(txtMobile.getText());
                patient.setAddress(txtAddress.getText());

                if(updateService.updatePatient(patient)){

                    JOptionPane.showMessageDialog(this,
                            "Patient Updated Successfully!");

                }else{

                    JOptionPane.showMessageDialog(this,
                            "Update Failed!");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Invalid Data");

            }

        });
        btnDelete.addActionListener(e -> {

            try {

                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this patient?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {

                    int id = Integer.parseInt(txtPatientId.getText());

                    if (deleteService.deletePatient(id)) {

                        JOptionPane.showMessageDialog(this,
                                "Patient Deleted Successfully!");

                        txtPatientId.setText("");
                        txtName.setText("");
                        txtAge.setText("");
                        txtGender.setText("");
                        txtDisease.setText("");
                        txtMobile.setText("");
                        txtAddress.setText("");

                    } else {

                        JOptionPane.showMessageDialog(this,
                                "Patient Not Found!");

                    }
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Patient ID");

            }

        });


        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,80,100,25);

        txtName = new JTextField();
        txtName.setBounds(150,80,250,25);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(30,120,100,25);

        txtAge = new JTextField();
        txtAge.setBounds(150,120,250,25);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,160,100,25);

        txtGender = new JTextField();
        txtGender.setBounds(150,160,250,25);

        JLabel lblDisease = new JLabel("Disease");
        lblDisease.setBounds(30,200,100,25);

        txtDisease = new JTextField();
        txtDisease.setBounds(150,200,250,25);

        JLabel lblMobile = new JLabel("Mobile");
        lblMobile.setBounds(30,240,100,25);

        txtMobile = new JTextField();
        txtMobile.setBounds(150,240,250,25);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30,280,100,25);

        txtAddress = new JTextField();
        txtAddress.setBounds(150,280,250,25);

        add(lblId);
        add(txtPatientId);
        add(btnSearch);

        add(lblName);
        add(txtName);

        add(lblAge);
        add(txtAge);

        add(lblGender);
        add(txtGender);

        add(lblDisease);
        add(txtDisease);

        add(lblMobile);
        add(txtMobile);

        add(lblAddress);
        add(txtAddress);
        add(btnSearch);
        add(btnUpdate);
        add(btnDelete);



        setVisible(true);
    }
}