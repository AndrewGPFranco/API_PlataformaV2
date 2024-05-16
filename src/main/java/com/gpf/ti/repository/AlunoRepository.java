package com.gpf.ti.repository;

import com.gpf.ti.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    @Query("SELECT a FROM Aluno a WHERE a.email = :email")
    Aluno findByEmail(String email);
}
