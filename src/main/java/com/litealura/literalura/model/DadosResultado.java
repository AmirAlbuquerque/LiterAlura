package com.litealura.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosResultado<T> {
    private List<T> results;

    public List<T> getResults() {return results;}

    public void setResults(List<T> results) {
        this.results = results;
    }
}
