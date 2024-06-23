package com.gpf.ti.repository;

import com.gpf.ti.enums.TechnologyType;
import com.gpf.ti.model.Aula;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

    @Query("SELECT p FROM Aula p WHERE p.tech = :tech")
    List<Aula> aulaPorTech(@Param("tech") TechnologyType tech);

    @Modifying
    @Transactional
    @Query("UPDATE Aula a SET a.visualizacoes = :contagem WHERE a.id = :id")
    void atualizarContagemDeVisualizacoes(@Param("contagem") Integer contagem, @Param("id") Long id);
}
