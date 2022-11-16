package com.example.reservasibioskop.controller;

import com.example.reservasibioskop.dto.InvoiceDTO;
import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.Invoice;
import com.example.reservasibioskop.entity.UserEntity;
import com.example.reservasibioskop.repository.InvoiceRepository;
import com.example.reservasibioskop.service.InvoiceService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/getInvoice")
    public List<Invoice> getInvoice() {
        return invoiceRepository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
        return invoiceService.exportReport(format);
    }

    @PostMapping("/create")
    public InvoiceDTO create(@RequestBody InvoiceDTO request){
        final Invoice invoice = invoiceService.mapToEntity(request);
        final Invoice result = invoiceService.create(invoice);
        return invoiceService.mapToDto(result);
    }

}
