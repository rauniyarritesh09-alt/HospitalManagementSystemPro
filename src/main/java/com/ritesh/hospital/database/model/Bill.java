
package com.ritesh.hospital.database.model;

public class Bill {

    private int billId;
    private int patientId;
    private int doctorId;

    private int consultationFee;
    private int medicineCharge;
    private int testCharge;
    private int otherCharge;

    private int totalAmount;

    private String paymentMode;
    private String billDate;

    public Bill() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(int consultationFee) {
        this.consultationFee = consultationFee;
    }

    public int getMedicineCharge() {
        return medicineCharge;
    }

    public void setMedicineCharge(int medicineCharge) {
        this.medicineCharge = medicineCharge;
    }

    public int getTestCharge() {
        return testCharge;
    }

    public void setTestCharge(int testCharge) {
        this.testCharge = testCharge;
    }

    public int getOtherCharge() {
        return otherCharge;
    }

    public void setOtherCharge(int otherCharge) {
        this.otherCharge = otherCharge;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }
}