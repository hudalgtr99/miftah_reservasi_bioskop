package org.binar.isekaibioskop.entity;

//import org.hibernate.Hibernate;
//import java.util.Objects;

import lombok.*;
import javax.persistence.*;
//import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Studios")
public class StudioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "full_status")
    private Boolean fullStatus;

}