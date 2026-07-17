
package com.ritesh.hospital.database.pdf;

import com.itextpdf.text.*;
        import com.itextpdf.text.pdf.PdfWriter;
import com.ritesh.hospital.database.model.Bill;

import javax.swing.*;
        import java.io.FileOutputStream;

public class BillPDFGenerator {

    public void generatePDF(Bill bill) {

        try {

            Document document = new Document();

            PdfWriter.getInstance(document,
                    new FileOutputStream("Bill_" + bill.getBillId() + ".pdf"));

            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

            Paragraph title =
                    new Paragraph("HOSPITAL MANAGEMENT SYSTEM", titleFont);

            title.setAlignment(Element.ALIGN_CENTER);

            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Bill ID : " + bill.getBillId()));
            document.add(new Paragraph("Patient ID : " + bill.getPatientId()));
            document.add(new Paragraph("Doctor ID : " + bill.getDoctorId()));

            document.add(new Paragraph("-----------------------------------"));

            document.add(new Paragraph("Consultation Fee : ₹" +
                    bill.getConsultationFee()));

            document.add(new Paragraph("Medicine Charge : ₹" +
                    bill.getMedicineCharge()));

            document.add(new Paragraph("Test Charge : ₹" +
                    bill.getTestCharge()));

            document.add(new Paragraph("Other Charge : ₹" +
                    bill.getOtherCharge()));

            document.add(new Paragraph("-----------------------------------"));

            document.add(new Paragraph("Total Amount : ₹" +
                    bill.getTotalAmount()));

            document.add(new Paragraph("Payment Mode : " +
                    bill.getPaymentMode()));

            document.add(new Paragraph("Bill Date : " +
                    bill.getBillDate()));

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Thank You. Visit Again!"));

            document.close();

            JOptionPane.showMessageDialog(null,
                    "PDF Generated Successfully!");

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(null,
                    "PDF Generation Failed!");

        }

    }
}