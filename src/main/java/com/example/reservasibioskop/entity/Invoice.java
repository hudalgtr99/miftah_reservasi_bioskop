package com.example.reservasibioskop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "Invoice")
public class Invoice {
    @Id
    private Long id;
    private String username;
    private String filmName;
    private String showDate;
    private String seatDetail;
    private Integer price;
}
