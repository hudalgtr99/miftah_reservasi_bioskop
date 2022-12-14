package org.binar.isekaibioskop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(value = {"createdAt", "updatedAt", "orderEntity"}, allowGetters = true)
@Table(name = "Users")
public class UserEntity extends BaseEntity {

    private String username;
    private String email;
    private String password;

    @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
    @JsonIgnore
    private OrderEntity orderEntity;
}