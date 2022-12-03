package org.binar.isekaibioskop.entity;



import lombok.*;
import javax.persistence.*;

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
