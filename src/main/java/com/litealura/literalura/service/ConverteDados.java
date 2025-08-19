package com.litealura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> List<T> obterDados(String json, Class<T> classe) {

        JsonNode root = null;
        try {
            root = mapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonNode resultsNode = root.get("results");
        CollectionType listType = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);

        try {
            return mapper.readValue(resultsNode.toString(), listType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
