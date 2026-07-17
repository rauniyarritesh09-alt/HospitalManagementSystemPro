package com.ritesh.hospital.database.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.ritesh.hospital.database.model.Appointment;

import javax.swing.*;
import java.io.FileOutputStream;

public class AppointmentPDFGenerator {

    public void generatePDF(Appointment appointment) {

        try {

            Document document = new Document();

            String fileName = "Appointment_" +
                    appointment.getAppointmentId() + ".pdf";

            PdfWriter.getInstance(document,
                    new FileOutputStream(fileName));

            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);

            document.add(new Paragraph("HOSPITAL MANAGEMENT SYSTEM", titleFont));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("APPOINTMENT SLIP", titleFont));
            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Appointment ID : " + appointment.getAppointmentId(),
                    normalFont));
            document.add(new Paragraph(
                    "Patient Name : " + appointment.getPatientName(),
                    normalFont));

            document.add(new Paragraph(
                    "Doctor Name : " + appointment.getDoctorName(),
                    normalFont));



            document.add(new Paragraph(
                    "Appointment Date : " + appointment.getAppointmentDate(),
                    normalFont));

            document.add(new Paragraph(
                    "Appointment Time : " + appointment.getAppointmentTime(),
                    normalFont));

            document.add(new Paragraph(
                    "Status : " + appointment.getStatus(),
                    normalFont));

            document.add(new Paragraph(" "));
            document.add(new Paragraph(
                    "Thank You!",
                    titleFont));

            document.close();

            JOptionPane.showMessageDialog(
                    null,
                    "PDF Saved Successfully!\n" + fileName);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    null,
                    "Failed to Generate PDF!");

        }
    }
}
