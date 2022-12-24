package org.binaracademy.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String filmName;
    private String showDate;
    private String seatDetail;
    private Integer price;
}