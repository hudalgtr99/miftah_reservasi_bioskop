package org.binaracademy.userservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Users")
public class UserEntity {

    @Id
    private String username;
    private String email;
    private String password;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROlE_ID")
            }
    )
    private Set<Role> role;

}
