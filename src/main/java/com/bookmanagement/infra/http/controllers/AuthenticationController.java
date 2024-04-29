package com.bookmanagement.infra.http.controllers;

import com.bookmanagement.infra.http.controllers.forms.AuthForm;
import com.bookmanagement.infra.http.security.services.TokenService;
import com.bookmanagement.infra.http.security.token.TokenJWT;
import com.bookmanagement.infra.persistence.entity.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenJWT> authenticate(@RequestBody @Valid AuthForm form) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(form.username(), form.password());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}
