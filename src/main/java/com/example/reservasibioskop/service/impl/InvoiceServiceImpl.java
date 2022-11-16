package com.example.reservasibioskop.service.impl;

import com.example.reservasibioskop.dto.InvoiceDTO;
import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.Invoice;
import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.repository.InvoiceRepository;
import com.example.reservasibioskop.service.InvoiceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "B:\\!!!!!! Semester 5\\Studpen Binar\\Coding Intellij\\Challenge_4_Miftahul Huda Guntara\\ReservasiBioskop";

        List<Invoice> invoices = invoiceRepository.findAll();
        File file = ResourceUtils.getFile("classpath:invoices.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(invoices);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("created by", "Miftahul Huda Guntara");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\invoices.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\invoices.pdf");
        }

        return "report generated in path: " + path;
    }

    @Override
    public Invoice create(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public InvoiceDTO mapToDto(Invoice invoice) {
        return mapper.convertValue(invoice, InvoiceDTO.class);
    }

    @Override
    public Invoice mapToEntity(InvoiceDTO invoiceDTO) {
        return mapper.convertValue(invoiceDTO, Invoice.class);
    }
}
