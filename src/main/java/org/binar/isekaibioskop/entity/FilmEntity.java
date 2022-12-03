package org.binar.isekaibioskop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private List<ScheduleEntity> scheduleEntities;
}