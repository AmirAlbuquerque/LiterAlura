package com.litealura.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String autor;
    private String idioma;
    private Integer downloads;

    public Livro(List<DadosLivro> dadosLivro) {
    this.titulo = dadosLivro.get(0).titulo();
    this.autor = dadosLivro.get(0).autores().get(0).autor();
    this.idioma = dadosLivro.get(0).idioma() != null && !dadosLivro.get(0).idioma().isEmpty()
        ? dadosLivro.get(0).idioma().get(0) : null;
    this.downloads = dadosLivro.get(0).downloads();
    }

    public Livro(){}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo +
                " | Autor: " + autor +
                " | Idioma: " + idioma +
                " | Downloads: " + downloads;
    }
}