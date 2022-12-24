package org.binaracademy.movieservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Table(name = "Films")
public class FilmEntity extends BaseEntity{

    private String name;

    private String description;

    private Integer duration;

    private String language;

    @Column(name = "show_status")
    private Boolean showStatus;

}
