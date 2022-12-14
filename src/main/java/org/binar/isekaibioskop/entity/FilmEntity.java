package org.binar.isekaibioskop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt", "orderDetail"}, allowGetters = true)
@Table(name = "Films")
public class FilmEntity extends BaseEntity{

    private String name;

    @Lob
    private String description;

    private Integer duration;

    private String language;

    @Column(name = "show_status")
    private Boolean showStatus;

    @OneToOne(mappedBy = "filmDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private ScheduleEntity scheduleEntity;
}