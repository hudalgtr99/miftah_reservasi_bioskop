package org.binaracademy.seatservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Table(name = "Studios")
public class StudioEntity extends BaseEntity{

    private String name;

    @Column(name = "full_status")
    private Boolean fullStatus;

}