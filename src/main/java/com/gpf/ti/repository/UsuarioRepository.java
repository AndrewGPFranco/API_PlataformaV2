package com.gpf.ti.repository;

import com.gpf.ti.enums.GeneroType;
import com.gpf.ti.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);

    @Query("SELECT u FROM Usuario u WHERE u.login = :login")
    Usuario getUsuario(@Param("login") String login);

    @Query("SELECT u FROM Usuario u WHERE u.login = :login AND u.admin = true")
    Usuario getUsuarioWithAdmin(@Param("login") String login);

    @Modifying
    @Transactional
    @Query("INSERT INTO Usuario (login, senha, admin, nomeCompleto, dataNascimento, genero, telefone) VALUES (:login, :senha, :admin, :nomeCompleto, :dataNascimento, :genero, :telefone)")
    void registerUser(@Param("login") String login, @Param("senha") String senha, @Param("admin") Boolean admin, @Param("nomeCompleto") String nomeCompleto, @Param("dataNascimento") LocalDate dataNascimento, @Param("genero") GeneroType genero, @Param("telefone") String telefone);
}
