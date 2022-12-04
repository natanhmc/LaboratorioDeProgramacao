package com.example.AS.repository;

import com.example.AS.model.aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AlunoRepository extends JpaRepository <aluno,Long>{
}
