package com.example.demo.controller;
import com.example.demo.auth.JwtUtil;
import com.example.demo.model.AdminUser;
import com.example.demo.model.auth.AuthenticationRequest;
import com.example.demo.model.auth.AuthenticationResponse;
import com.example.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/")
@RestController
public class AuthenticationController {


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtUtil jwtTokenUtil;


    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {

            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));


        } catch (AuthenticationException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        AdminUser adminUser =  new AdminUser(authenticationRequest.getUsername(), ""  );


        final String jwt = jwtTokenUtil.createToken(adminUser);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
