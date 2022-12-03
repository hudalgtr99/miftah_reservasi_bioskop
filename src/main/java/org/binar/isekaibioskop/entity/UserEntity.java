package org.binar.isekaibioskop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class UserEntity {

    @Id
    private String username;
    private String email;
    private String password;
}