package com.ritesh.hospital.database.ui;

import com.github.lgooddatepicker.components.DatePicker;
import com.ritesh.hospital.database.service.BillingService;
import com.ritesh.hospital.database.service.DoctorComboService;
import com.ritesh.hospital.database.service.PatientComboService;

import javax.swing.*;
import com.ritesh.hospital.database.model.Bill;
import com.ritesh.hospital.database.pdf.BillPDFGenerator;


public class BillingForm extends JFrame {

    private JTextField txtBillId;
    private JTextField txtConsultationFee;
    private JTextField txtMedicineCharge;
    private JTextField txtTestCharge;
    private JTextField txtOtherCharge;
    private JTextField txtTotalAmount;

    private JComboBox<String> cmbPatient;
    private JComboBox<String> cmbDoctor;
    private JComboBox<String> cmbPaymentMode;

    private DatePicker datePicker;

    private JButton btnCalculate;
    private JButton btnSave;
    private JButton btnExportPDF;

    PatientComboService patientService = new PatientComboService();
    DoctorComboService doctorService = new DoctorComboService();
    BillingService billingService = new BillingService();

    public BillingForm() {

        setTitle("Billing Management");
        setSize(700,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("BILLING MANAGEMENT");
        lblTitle.setBounds(240,20,250,30);

        JLabel lblBillId = new JLabel("Bill ID");
        lblBillId.setBounds(40,70,140,25);

        txtBillId = new JTextField();
        txtBillId.setBounds(220,70,250,25);

        JLabel lblPatient = new JLabel("Patient");
        lblPatient.setBounds(40,110,140,25);

        cmbPatient = new JComboBox<>();
        cmbPatient.setBounds(220,110,350,25);

        JLabel lblDoctor = new JLabel("Doctor");
        lblDoctor.setBounds(40,150,140,25);

        cmbDoctor = new JComboBox<>();
        cmbDoctor.setBounds(220,150,350,25);

        JLabel lblConsultation = new JLabel("Consultation Fee");
        lblConsultation.setBounds(40,190,140,25);

        txtConsultationFee = new JTextField();
        txtConsultationFee.setBounds(220,190,250,25);

        JLabel lblMedicine = new JLabel("Medicine Charge");
        lblMedicine.setBounds(40,230,140,25);

        txtMedicineCharge = new JTextField();
        txtMedicineCharge.setBounds(220,230,250,25);

        JLabel lblTest = new JLabel("Test Charge");
        lblTest.setBounds(40,270,140,25);

        txtTestCharge = new JTextField();
        txtTestCharge.setBounds(220,270,250,25);

        JLabel lblOther = new JLabel("Other Charge");
        lblOther.setBounds(40,310,140,25);

        txtOtherCharge = new JTextField();
        txtOtherCharge.setBounds(220,310,250,25);

        JLabel lblTotal = new JLabel("Total Amount");
        lblTotal.setBounds(40,350,140,25);

        txtTotalAmount = new JTextField();
        txtTotalAmount.setBounds(220,350,250,25);
        txtTotalAmount.setEditable(false);

        JLabel lblPayment = new JLabel("Payment Mode");
        lblPayment.setBounds(40,390,140,25);

        cmbPaymentMode = new JComboBox<>();
        cmbPaymentMode.setBounds(220,390,250,25);

        JLabel lblDate = new JLabel("Bill Date");
        lblDate.setBounds(40,430,140,25);

        datePicker = new DatePicker();
        datePicker.setBounds(220,430,250,30);

        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(90,500,150,40);

        btnSave = new JButton("Save Bill");
        btnSave.setBounds(270,500,150,40);
        btnExportPDF = new JButton("Export PDF");
        btnExportPDF.setBounds(450, 500, 150, 40);


        add(lblTitle);
        add(lblBillId);
        add(txtBillId);

        add(lblPatient);
        add(cmbPatient);

        add(lblDoctor);
        add(cmbDoctor);

        add(lblConsultation);
        add(txtConsultationFee);

        add(lblMedicine);
        add(txtMedicineCharge);

        add(lblTest);
        add(txtTestCharge);

        add(lblOther);
        add(txtOtherCharge);

        add(lblTotal);
        add(txtTotalAmount);

        add(lblPayment);
        add(cmbPaymentMode);

        add(lblDate);
        add(datePicker);

        add(btnCalculate);
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
        cmbPaymentMode.addItem("Cash");
        cmbPaymentMode.addItem("UPI");
        cmbPaymentMode.addItem("Credit Card");
        cmbPaymentMode.addItem("Debit Card");
        cmbPaymentMode.addItem("Net Banking");

        btnCalculate.addActionListener(e -> {

            try {

                int consultation = Integer.parseInt(txtConsultationFee.getText());
                int medicine = Integer.parseInt(txtMedicineCharge.getText());
                int test = Integer.parseInt(txtTestCharge.getText());
                int other = Integer.parseInt(txtOtherCharge.getText());

                int total = consultation + medicine + test + other;

                txtTotalAmount.setText(String.valueOf(total));

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please Enter Valid Amounts");

            }

        });

        btnSave.addActionListener(e -> {

            try {

                Bill bill = new Bill();

                bill.setBillId(Integer.parseInt(txtBillId.getText()));

                // Patient ID
                String patient = cmbPatient.getSelectedItem().toString();
                int patientId = Integer.parseInt(patient.split(" - ")[0]);
                bill.setPatientId(patientId);

                // Doctor ID
                String doctor = cmbDoctor.getSelectedItem().toString();
                int doctorId = Integer.parseInt(doctor.split(" - ")[0]);
                bill.setDoctorId(doctorId);

                bill.setConsultationFee(Integer.parseInt(txtConsultationFee.getText()));
                bill.setMedicineCharge(Integer.parseInt(txtMedicineCharge.getText()));
                bill.setTestCharge(Integer.parseInt(txtTestCharge.getText()));
                bill.setOtherCharge(Integer.parseInt(txtOtherCharge.getText()));
                bill.setTotalAmount(Integer.parseInt(txtTotalAmount.getText()));

                bill.setPaymentMode(cmbPaymentMode.getSelectedItem().toString());

                if (datePicker.getDate() == null) {
                    JOptionPane.showMessageDialog(this,
                            "Please Select Bill Date");
                    return;
                }



                bill.setBillDate(datePicker.getDate().toString());

                if (billingService.addBill(bill)) {

                    JOptionPane.showMessageDialog(this,
                            "Bill Saved Successfully!");

                    // Clear Form
                    txtBillId.setText("");
                    txtConsultationFee.setText("");
                    txtMedicineCharge.setText("");
                    txtTestCharge.setText("");
                    txtOtherCharge.setText("");
                    txtTotalAmount.setText("");

                    datePicker.clear();

                    if (cmbPatient.getItemCount() > 0)
                        cmbPatient.setSelectedIndex(0);

                    if (cmbDoctor.getItemCount() > 0)
                        cmbDoctor.setSelectedIndex(0);

                    cmbPaymentMode.setSelectedIndex(0);

                } else {

                    JOptionPane.showMessageDialog(this,
                            "Failed to Save Bill!");

                }

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(this,
                        "Please Enter Valid Data");

            }

        });

        btnExportPDF.addActionListener(e -> {
            if (txtBillId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        " Please Enter Bill Details First");
                return;
            }

            try {

                Bill bill = new Bill();

                bill.setBillId(Integer.parseInt(txtBillId.getText()));
                bill.setPatientId(Integer.parseInt(cmbPatient.getSelectedItem().toString().split(" - ")[0]));
                bill.setDoctorId(Integer.parseInt(cmbDoctor.getSelectedItem().toString().split(" - ")[0]));

                bill.setConsultationFee(Integer.parseInt(txtConsultationFee.getText()));
                bill.setMedicineCharge(Integer.parseInt(txtMedicineCharge.getText()));
                bill.setTestCharge(Integer.parseInt(txtTestCharge.getText()));
                bill.setOtherCharge(Integer.parseInt(txtOtherCharge.getText()));
                bill.setTotalAmount(Integer.parseInt(txtTotalAmount.getText()));

                bill.setPaymentMode(cmbPaymentMode.getSelectedItem().toString());

                if (datePicker.getDate() == null) {
                    JOptionPane.showMessageDialog(this,
                            "Please Select Bill Date");
                    return;
                }

                bill.setBillDate(datePicker.getDate().toString());

                BillPDFGenerator pdf = new BillPDFGenerator();
                pdf.generatePDF(bill);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Please fill all fields correctly.");

                ex.printStackTrace();
            }

        });

        setVisible(true);
    }
}
