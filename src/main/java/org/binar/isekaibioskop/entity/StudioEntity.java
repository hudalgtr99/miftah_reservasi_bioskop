package org.binar.isekaibioskop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

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