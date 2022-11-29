package com.example.notas.repository;

import com.example.notas.model.nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface NotaRepository extends JpaRepository <nota,Long>{
}
