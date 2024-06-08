package com.gpf.ti.repository;

import com.gpf.ti.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);

    @Query("SELECT u FROM Usuario u WHERE u.login = :login")
    Usuario getUsuario(@Param("login") String login);

    @Query("SELECT u FROM Usuario u WHERE u.login = :login AND u.admin = true")
    Usuario getUsuarioWithAdmin(@Param("login") String login);

    @Modifying
    @Transactional
    @Query("INSERT INTO Usuario (login, senha, admin) VALUES (:login, :senha, :admin)")
    void registerUser(@Param("login") String login, @Param("senha") String senha, @Param("admin") Boolean admin);
}
