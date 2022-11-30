package com.example.notas.controller;

import com.example.notas.model.nota;
import com.example.notas.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class NotaController {
    @Autowired
    NotaRepository noteRepository;
    @GetMapping("/notes")
    public List<nota> getAllNotes(){
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public Optional<nota> getById(@PathVariable(value ="id") Long id){
        return noteRepository.findById(id);
    }
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNota(@PathVariable(value = "id") Long id){
        Optional<nota> note = noteRepository.findById(id);
        noteRepository.delete(note.get());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/notes/{id}")
    public nota updateNota(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody nota noteDetails){
        Optional<nota> note3 = noteRepository.findById(id);
        note3.get().setTitle(noteDetails.getTitle());
        note3.get().setContent(noteDetails.getContent());
        nota noteResponse = noteRepository.save(note3.get());
        return noteResponse;
    }

    @PostMapping("/notes")
    public nota createNote(@Valid @RequestBody nota nota1){
        return noteRepository.save(nota1);
    }
}
