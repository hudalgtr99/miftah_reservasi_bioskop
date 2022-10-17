package com.example.reservasibioskop.entity;

//import org.hibernate.Hibernate;
//import java.util.Objects;

import lombok.*;
import javax.persistence.*;
//import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Films")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;

    @Lob
    private String description;

    private Integer duration;

    private String language;

    @Column(name = "show_status")
    private Boolean showStatus;

//    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime updatedAt;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        FilmEntity that = (FilmEntity) o;
//        return code != null && Objects.equals(code, that.code);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
}
