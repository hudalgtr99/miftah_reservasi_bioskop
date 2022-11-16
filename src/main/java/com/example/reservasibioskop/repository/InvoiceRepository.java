package com.example.reservasibioskop.repository;

import com.example.reservasibioskop.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
