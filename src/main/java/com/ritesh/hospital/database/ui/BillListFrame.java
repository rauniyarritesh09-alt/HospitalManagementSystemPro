
package com.ritesh.hospital.database.ui;

import com.ritesh.hospital.database.service.BillViewService;

import javax.swing.*;
        import javax.swing.table.DefaultTableModel;

public class BillListFrame extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    BillViewService service = new BillViewService();

    public BillListFrame() {

        setTitle("Bill List");

        setSize(1100,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(null);

        String[] columns = {
                "Bill ID",
                "Patient ID",
                "Doctor ID",
                "Consultation",
                "Medicine",
                "Test",
                "Other",
                "Total",
                "Payment",
                "Bill Date"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,20,1040,400);

        add(scrollPane);

        service.loadBills(model);

        setVisible(true);
    }
}