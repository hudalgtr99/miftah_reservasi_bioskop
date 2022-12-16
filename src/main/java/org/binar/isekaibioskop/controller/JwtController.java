package org.binar.isekaibioskop.controller;

import org.binar.isekaibioskop.request.JwtRequest;
import org.binar.isekaibioskop.response.JwtResponse;
import org.binar.isekaibioskop.service.impl.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtServiceImpl jwtServiceImpl;

    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        return jwtServiceImpl.createJwtToken(jwtRequest);

    }
}
