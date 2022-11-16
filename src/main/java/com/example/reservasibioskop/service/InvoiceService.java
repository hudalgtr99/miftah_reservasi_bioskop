package com.example.reservasibioskop.service;

import com.example.reservasibioskop.dto.InvoiceDTO;
import com.example.reservasibioskop.dto.UserDTO;
import com.example.reservasibioskop.entity.FilmEntity;
import com.example.reservasibioskop.entity.Invoice;
import com.example.reservasibioskop.entity.UserEntity;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface InvoiceService {
    String exportReport(String reportFormat) throws FileNotFoundException, JRException;
    Invoice create(Invoice invoice);

    InvoiceDTO mapToDto(Invoice invoice);
    Invoice mapToEntity(InvoiceDTO InvoiceDTO);
}
