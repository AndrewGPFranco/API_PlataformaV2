package com.gpf.ti.services;

import com.gpf.ti.dtos.usuario.UserDTO;
import com.gpf.ti.exception.FormatoInvalidoException;
import com.gpf.ti.exception.SenhaComPoucosCaracteresException;
import com.gpf.ti.infra.security.SecurityConfigurations;
import com.gpf.ti.model.Usuario;
import com.gpf.ti.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Autowired
    private SecurityConfigurations security;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public Usuario getUser(String login) throws UsernameNotFoundException {
        return repository.getUsuario(login);
    }

    public Usuario getUserWithAdmin(String login) throws UsernameNotFoundException {
        return repository.getUsuarioWithAdmin(login);
    }

    public void registerUser(@Valid UserDTO dto) {
        if (dto.senha().length() < 5) {
            throw new SenhaComPoucosCaracteresException();
        }

        String regex = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$";
        String login = dto.login();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(login);
        if (!matcher.matches()) {
            throw new FormatoInvalidoException("Formato de login inválido");
        }

        String senha = security.passwordEncoder().encode(dto.senha());
        repository.registerUser(dto.login(), senha, dto.admin());
    }
}
