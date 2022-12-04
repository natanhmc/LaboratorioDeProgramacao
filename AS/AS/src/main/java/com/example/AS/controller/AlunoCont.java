package com.example.AS.controller;


import com.example.AS.model.aluno;
import com.example.AS.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlunoCont { @Autowired
AlunoRepository alunoRepository;
    @GetMapping("/alunos")
    public List<aluno> getAllAluno(){
        List<aluno> all = AlunoRepository.findAll();
        return all;
    }

    @GetMapping("/alunos/{id}")
    public Optional<aluno> getById(@PathVariable(value ="id") Long id){
        Optional<aluno> byId = AlunoRepository.findById(id);
        Optional<aluno> byId1 = byId;
        return byId1;
    }
    @DeleteMapping("/alunos/{id}")
    public ResponseEntity<?> deleteAluno(@PathVariable(value = "id") Long id){
        Optional<aluno> aluno = AlunoRepository.findById(id);
        AlunoRepository.delete(aluno.get());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alunos/{id}")
    public aluno updateAluno(@PathVariable(value = "id") Long id,
                             @Valid @RequestBody aluno alunoDetails){
        Optional<aluno> aluno3 = AlunoRepository.findById(id);
        aluno3.get().setNome(alunoDetails.getNome());
        aluno3.get().setTurma(alunoDetails.getTurma());
        aluno noteResponse = AlunoRepository.save(aluno3.get());
        return noteResponse;
    }

    @PostMapping("/alunos")
    public aluno createAluno(@Valid @RequestBody aluno aluno1){
        return AlunoRepository.save(aluno1);
    }
}