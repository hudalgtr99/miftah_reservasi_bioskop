package org.binar.isekaibioskop.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequest {

    private String userName;
    private String userPassword;
}
