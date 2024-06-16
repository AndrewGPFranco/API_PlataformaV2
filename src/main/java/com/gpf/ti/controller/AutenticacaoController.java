package com.gpf.ti.controller;

import com.gpf.ti.dtos.infra.DadosAutenticaoDto;
import com.gpf.ti.dtos.infra.DadosTokenJwtDto;
import com.gpf.ti.dtos.infra.DadosUsuarioIsAdmin;
import com.gpf.ti.model.Usuario;
import com.gpf.ti.services.AutenticacaoService;
import com.gpf.ti.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticaoDto dados) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            var authentication = manager.authenticate(authenticationToken);

            var tokenJwt = tokenService.gerarToken((Usuario) authentication.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJwtDto(tokenJwt));
        } catch (AuthenticationException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("Erro", e.getMessage());
            return new ResponseEntity(response, HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<DadosUsuarioIsAdmin> getUser(@RequestParam String login) {
        try {
            Usuario user = autenticacaoService.getUser(login);
            DadosUsuarioIsAdmin usuarioRetornado = new DadosUsuarioIsAdmin(user.getAdmin());
            return new ResponseEntity<>(usuarioRetornado, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/admin")
    public ResponseEntity<DadosUsuarioIsAdmin> getUserAdmin(@RequestParam String login) {
        try {
            Usuario user = autenticacaoService.getUserWithAdmin(login);
            DadosUsuarioIsAdmin usuarioRetornado = new DadosUsuarioIsAdmin(user.getAdmin());
            return new ResponseEntity<>(usuarioRetornado, HttpStatus.OK);
        } catch (UsernameNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
