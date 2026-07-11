
package com.ritesh.hospital.database.ui;
import com.ritesh.hospital.database.service.PatientViewService;

import javax.swing.table.DefaultTableModel;

import javax.swing.*;

public class PatientListFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    PatientViewService service = new PatientViewService();

    public PatientListFrame() {

        setTitle("Patient List");

        setSize(900,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);
        String[] columns = {
                "Patient ID",
                "Name",
                "Age",
                "Gender",
                "Disease",
                "Mobile",
                "Address"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,20,840,400);

        add(scrollPane);

        service.loadPatients(model);

        setVisible(true);
    }
}