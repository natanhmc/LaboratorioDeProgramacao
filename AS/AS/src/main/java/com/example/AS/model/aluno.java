package com.example.AS.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "alunos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updateAt"},
        allowGetters = true)
public class aluno{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idalunos;
    @NotBlank
    private String Nome;
    @NotBlank
    private String Turma;
    public Long getIdaluno() {
        return idalunos;
    }

    public void setIdaluno(Long idalunos) {
        this.idalunos = idalunos;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getTurma() {
        return Turma;
    }

    public void setTurma(String turma) {
        Turma = turma;
    }
}