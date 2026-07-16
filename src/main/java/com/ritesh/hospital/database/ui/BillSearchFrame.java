
package com.ritesh.hospital.database.ui;

import com.ritesh.hospital.database.model.Bill;
import com.ritesh.hospital.database.service.BillSearchService;
import com.ritesh.hospital.database.service.BillUpdateService;
import com.ritesh.hospital.database.service.BillDeleteService;

import javax.swing.*;

public class BillSearchFrame extends JFrame {

    private JTextField txtBillId;
    private JTextField txtPatientId;
    private JTextField txtDoctorId;
    private JTextField txtConsultation;
    private JTextField txtMedicine;
    private JTextField txtTest;
    private JTextField txtOther;
    private JTextField txtTotal;
    private JTextField txtPayment;
    private JTextField txtDate;

    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnDelete;

    BillSearchService service = new BillSearchService();
    BillUpdateService updateService = new BillUpdateService();
    BillDeleteService deleteService = new BillDeleteService();

    public BillSearchFrame() {

        setTitle("Search Bill");
        setSize(550, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblBillId = new JLabel("Bill ID");
        lblBillId.setBounds(30,30,120,25);

        txtBillId = new JTextField();
        txtBillId.setBounds(180,30,180,25);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(380,30,100,25);


        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(160, 470, 120, 35);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(300, 470, 120, 35);
        btnUpdate.addActionListener(e -> {

            try {

                Bill bill = new Bill();

                bill.setBillId(Integer.parseInt(txtBillId.getText()));
                bill.setPatientId(Integer.parseInt(txtPatientId.getText()));
                bill.setDoctorId(Integer.parseInt(txtDoctorId.getText()));
                bill.setConsultationFee(Integer.parseInt(txtConsultation.getText()));
                bill.setMedicineCharge(Integer.parseInt(txtMedicine.getText()));
                bill.setTestCharge(Integer.parseInt(txtTest.getText()));
                bill.setOtherCharge(Integer.parseInt(txtOther.getText()));
                bill.setTotalAmount(Integer.parseInt(txtTotal.getText()));
                bill.setPaymentMode(txtPayment.getText());
                bill.setBillDate(txtDate.getText());

                if (updateService.updateBill(bill)) {

                    JOptionPane.showMessageDialog(this,
                            "Bill Updated Successfully!");

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Update Failed!");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Invalid Data!");

            }

        });
        btnDelete.addActionListener(e -> {

            try {

                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this bill?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {

                    int billId = Integer.parseInt(txtBillId.getText());

                    if (deleteService.deleteBill(billId)) {

                        JOptionPane.showMessageDialog(this,
                                "Bill Deleted Successfully!");

                        txtBillId.setText("");
                        txtPatientId.setText("");
                        txtDoctorId.setText("");
                        txtConsultation.setText("");
                        txtMedicine.setText("");
                        txtTest.setText("");
                        txtOther.setText("");
                        txtTotal.setText("");
                        txtPayment.setText("");
                        txtDate.setText("");

                    } else {

                        JOptionPane.showMessageDialog(this,
                                "Bill Not Found!");

                    }
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Bill ID");

            }

        });

        JLabel lblPatient = new JLabel("Patient ID");
        lblPatient.setBounds(30,80,120,25);

        txtPatientId = new JTextField();
        txtPatientId.setBounds(180,80,250,25);

        JLabel lblDoctor = new JLabel("Doctor ID");
        lblDoctor.setBounds(30,120,120,25);

        txtDoctorId = new JTextField();
        txtDoctorId.setBounds(180,120,250,25);

        JLabel lblConsultation = new JLabel("Consultation Fee");
        lblConsultation.setBounds(30,160,120,25);

        txtConsultation = new JTextField();
        txtConsultation.setBounds(180,160,250,25);

        JLabel lblMedicine = new JLabel("Medicine Charge");
        lblMedicine.setBounds(30,200,120,25);

        txtMedicine = new JTextField();
        txtMedicine.setBounds(180,200,250,25);

        JLabel lblTest = new JLabel("Test Charge");
        lblTest.setBounds(30,240,120,25);

        txtTest = new JTextField();
        txtTest.setBounds(180,240,250,25);

        JLabel lblOther = new JLabel("Other Charge");
        lblOther.setBounds(30,280,120,25);

        txtOther = new JTextField();
        txtOther.setBounds(180,280,250,25);

        JLabel lblTotal = new JLabel("Total Amount");
        lblTotal.setBounds(30,320,120,25);

        txtTotal = new JTextField();
        txtTotal.setBounds(180,320,250,25);

        JLabel lblPayment = new JLabel("Payment Mode");
        lblPayment.setBounds(30,360,120,25);

        txtPayment = new JTextField();
        txtPayment.setBounds(180,360,250,25);

        JLabel lblDate = new JLabel("Bill Date");
        lblDate.setBounds(30,400,120,25);

        txtDate = new JTextField();
        txtDate.setBounds(180,400,250,25);

        add(lblBillId);
        add(txtBillId);
        add(btnSearch);

        add(lblPatient);
        add(txtPatientId);

        add(lblDoctor);
        add(txtDoctorId);

        add(lblConsultation);
        add(txtConsultation);

        add(lblMedicine);
        add(txtMedicine);

        add(lblTest);
        add(txtTest);

        add(lblOther);
        add(txtOther);

        add(lblTotal);
        add(txtTotal);

        add(lblPayment);
        add(txtPayment);

        add(lblDate);
        add(txtDate);
        btnSearch.addActionListener(e -> {

            try {

                int billId = Integer.parseInt(txtBillId.getText());

                Bill bill = service.searchBill(billId);

                if (bill != null) {

                    txtPatientId.setText(String.valueOf(bill.getPatientId()));
                    txtDoctorId.setText(String.valueOf(bill.getDoctorId()));
                    txtConsultation.setText(String.valueOf(bill.getConsultationFee()));
                    txtMedicine.setText(String.valueOf(bill.getMedicineCharge()));
                    txtTest.setText(String.valueOf(bill.getTestCharge()));
                    txtOther.setText(String.valueOf(bill.getOtherCharge()));
                    txtTotal.setText(String.valueOf(bill.getTotalAmount()));
                    txtPayment.setText(bill.getPaymentMode());
                    txtDate.setText(bill.getBillDate());

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Bill Not Found!");

                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Bill ID");

            }

        });
        add(btnUpdate);
        add(btnDelete);

        setVisible(true);
    }
}