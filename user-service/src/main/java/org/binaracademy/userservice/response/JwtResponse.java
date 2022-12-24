package org.binaracademy.userservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.binaracademy.userservice.entity.UserEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private UserEntity userEntity;
    private String jwtToken;
}