package com.litealura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutor(@JsonAlias("name") String autor,
                         @JsonAlias("birth_year") Integer anoNascimento,
                         @JsonAlias("death_year") Integer anoMorte) {
}
