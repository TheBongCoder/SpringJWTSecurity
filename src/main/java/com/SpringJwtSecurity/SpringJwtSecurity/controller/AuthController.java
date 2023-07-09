package com.SpringJwtSecurity.SpringJwtSecurity.controller;

import com.SpringJwtSecurity.SpringJwtSecurity.dto.AuthRequestDTO;
import com.SpringJwtSecurity.SpringJwtSecurity.dto.AuthResponseDTO;
import com.SpringJwtSecurity.SpringJwtSecurity.entity.User;
import com.SpringJwtSecurity.SpringJwtSecurity.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/auth/signIn")
    public ResponseEntity<?> signIn(@RequestBody @Valid AuthRequestDTO authRequestDTO) {
        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getEmail(), authRequestDTO.getPassword()));
            User user = (User) authenticate.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(user);
            AuthResponseDTO authResponseDTO = new AuthResponseDTO(accessToken);
            return ResponseEntity.ok(authResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
        }
    }
}

