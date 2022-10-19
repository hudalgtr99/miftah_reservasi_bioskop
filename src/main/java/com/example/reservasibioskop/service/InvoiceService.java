package com.example.reservasibioskop.service;

import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class InvoiceService {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Invoice.pdf"));
            document.open();

            document.add(new Paragraph("Invoice Reservasi Bioskop"));

            Image image1 = Image.getInstance("Header.png");
            image1.setAbsolutePosition(100f, 675f);
            image1.scaleAbsolute(384, 98);
            document.add(image1);

            //Row 1
            PdfPTable row1 = new PdfPTable(5);
            row1.setWidthPercentage(100); //Width 100%
            row1.setSpacingBefore(150f); //Space before row1
            row1.setSpacingAfter(1f); //Space after row1

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f};
            row1.setWidths(columnWidths);

            PdfPCell row1cell1 = new PdfPCell(new Paragraph("Film Name"));
            row1cell1.setBorderColor(BaseColor.BLUE);
            row1cell1.setPaddingLeft(10);
            row1cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row1cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell row1cell2 = new PdfPCell(new Paragraph("Seat"));
            row1cell2.setBorderColor(BaseColor.RED);
            row1cell2.setPaddingLeft(10);
            row1cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row1cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell row1cell3 = new PdfPCell(new Paragraph("Show Date"));
            row1cell3.setBorderColor(BaseColor.GREEN);
            row1cell3.setPaddingLeft(10);
            row1cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            row1cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell row1cell4 = new PdfPCell(new Paragraph("Username"));
            row1cell4.setBorderColor(BaseColor.YELLOW);
            row1cell4.setPaddingLeft(10);
            row1cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            row1cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell row1cell5 = new PdfPCell(new Paragraph("Price"));
            row1cell5.setBorderColor(BaseColor.CYAN);
            row1cell5.setPaddingLeft(10);
            row1cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            row1cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

            //Row 2
            PdfPTable row2 = new PdfPTable(5);
            row2.setWidthPercentage(100); //Width 100%

            //Set Column widths
            float[] columnWidths2 = {1f, 1f, 1f, 1f, 1f};
            row2.setWidths(columnWidths2);

            PdfPCell row2cell1 = new PdfPCell(new Paragraph("Kimi no Nawa"));
            row2cell1.setBorderColor(BaseColor.BLACK);
            row2cell1.setPaddingLeft(10);
            row2cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            row2cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell row2cell2 = new PdfPCell(new Paragraph("A1"));
            row2cell2.setPaddingLeft(10);
            row2cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            row2cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell row2cell3 = new PdfPCell(new Paragraph("30-09-2022 19:00"));
            row2cell3.setPaddingLeft(10);
            row2cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            row2cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell row2cell4 = new PdfPCell(new Paragraph("Miftah"));
            row2cell4.setPaddingLeft(10);
            row2cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            row2cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

            PdfPCell row2cell5 = new PdfPCell(new Paragraph("Rp. 25000"));
            row2cell5.setPaddingLeft(10);
            row2cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            row2cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

            row1.addCell(row1cell1);
            row1.addCell(row1cell2);
            row1.addCell(row1cell3);
            row1.addCell(row1cell4);
            row1.addCell(row1cell5);
            row2.addCell(row2cell1);
            row2.addCell(row2cell2);
            row2.addCell(row2cell3);
            row2.addCell(row2cell4);
            row2.addCell(row2cell5);

            document.add(row1);
            document.add(row2);

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}