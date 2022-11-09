package com.example.reservasibioskop.entity;


public class JwtResponse {

    private UserEntity userEntity;
    private String jwtToken;

    public JwtResponse(UserEntity userEntity, String jwtToken) {
        this.userEntity = userEntity;
        this.jwtToken = jwtToken;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}