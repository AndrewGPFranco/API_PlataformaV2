package com.gpf.ti.repository;

import com.gpf.ti.enums.TechnologyEnum;
import com.gpf.ti.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {

    @Query("SELECT p FROM Aula p WHERE p.tech = :tech")
    List<Aula> aulaPorTech(@Param("tech") TechnologyEnum tech);
}
