package org.binaracademy.orderservice.service.impl;

import org.binaracademy.orderservice.entity.Invoice;

import java.util.List;

public class InvoiceServiceImpl {

    //Data Dummy for Invoice
    public static List<Invoice> generateInvoiceList(){
        return List.of(
                new Invoice(1L, "Miftah", "filmDummy", "01/01/2022", "A1", 25000)
        );
    }
}