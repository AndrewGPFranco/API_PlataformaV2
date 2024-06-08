package com.gpf.ti.controller;

import com.gpf.ti.dtos.usuario.UserDTO;
import com.gpf.ti.services.AutenticacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody UserDTO dto) {
        autenticacaoService.registerUser(dto);
    }
}
