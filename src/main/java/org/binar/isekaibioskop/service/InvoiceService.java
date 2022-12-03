package org.binar.isekaibioskop.service;

import org.binar.isekaibioskop.entity.Invoice;
import java.util.List;

public class InvoiceService {
    public static List<Invoice> generateInvoiceList(){
        return List.of(
                new Invoice(1L, "Miftah", "filmDummy", "01/01/2022", "A1", 25000)
        );
    }
}