package org.binar.isekaibioskop.entity;


//import org.hibernate.Hibernate;
//import java.util.Objects;

import lombok.*;
import org.binar.isekaibioskop.entity.embedded.SeatDetailEntity;

import javax.persistence.*;
import java.util.List;
//import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "Users_id")
    private UserEntity userEntity;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "Films_id")
    private FilmEntity filmEntity;

    @OneToMany
    @JoinColumn(name = "SeatDetail_id")
    private List<SeatDetailEntity> seatDetailEntities;

    private Integer quantity;

//    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime createdAt;
//
//    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime updatedAt;

}