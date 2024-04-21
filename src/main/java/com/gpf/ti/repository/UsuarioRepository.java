package com.gpf.ti.repository;

import com.gpf.ti.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);

    @Query("SELECT u FROM Usuario u WHERE u.login = :login")
    Usuario getUsuario(@Param("login") String login);
}
