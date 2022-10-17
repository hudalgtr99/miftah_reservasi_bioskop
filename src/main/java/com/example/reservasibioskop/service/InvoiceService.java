package com.example.reservasibioskop.service;
import java.io.FileOutputStream;


import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class InvoiceService {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Invoice.pdf"));
            document.open();
            document.add(new Paragraph("Reservasi Bioskop"));
            Image image1 = Image.getInstance("Header.png");
            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
