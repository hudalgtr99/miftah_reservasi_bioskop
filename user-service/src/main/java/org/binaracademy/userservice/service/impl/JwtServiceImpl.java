package org.binaracademy.userservice.service.impl;

import org.binaracademy.userservice.entity.UserEntity;
import org.binaracademy.userservice.repository.UserRepository;
import org.binaracademy.userservice.request.JwtRequest;
import org.binaracademy.userservice.response.JwtResponse;
import org.binaracademy.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);

        final UserDetails userDetails = loadUserByUsername(userName);

        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        UserEntity userEntity = userRepository.findById(userName).get();

        return new JwtResponse(userEntity, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findById(username).get();

        if(userEntity != null){
            return new User(
                    userEntity.getUsername(),
                    userEntity.getPassword(),
                    getAuthorities(userEntity)
            );
        } else{
            throw new UsernameNotFoundException("Username is not valid");
        }
    }

    private Set getAuthorities(UserEntity userEntity){
        Set authorities = new HashSet();

        userEntity.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });

        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception{

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e){
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e){
            throw new Exception("Bad credentials form user");
        }
    }
}