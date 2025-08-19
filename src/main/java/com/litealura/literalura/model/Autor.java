package com.litealura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nome;
    private Integer anoNascimento;
    private Integer anoMorte;

    public Autor (){}

    public Autor(List<DadosLivro> dadosLivro){
        this.nome = dadosLivro.get(0).autores().get(0).autor();
        this.anoNascimento = dadosLivro.get(0).autores().get(0).anoNascimento();
        this.anoMorte = dadosLivro.get(0).autores().get(0).anoMorte();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(Integer anoMorte) {
        this.anoMorte = anoMorte;
    }

    @Override
    public String toString() {
        return "Autor: " + nome + '\'' +
                ", Ano nascimento: " + anoNascimento +
                ", Ano morte: " + anoMorte +
                '}';
    }
}
