package com.gpf.ti.services;

import com.gpf.ti.model.Usuario;
import com.gpf.ti.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

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
}
