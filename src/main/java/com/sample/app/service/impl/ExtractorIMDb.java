package com.sample.app.service.impl;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.app.model.Conteudo;
import com.sample.app.repository.ConteudoRepository;
import com.sample.app.service.IExtractor;

public class ExtractorIMDb implements IExtractor {

    @Override
    public List<Conteudo> extrairConteudos(String json) {
        ConteudoRepository conjuntoImagens = new ConteudoRepository();
        
        ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        String dados = "";
        try {
            dados = mapper.readTree(json)
                .get("items")
                .toString();
            
            conjuntoImagens.addConteudo(mapper.readValue(dados, Conteudo[].class));
        } catch (JsonProcessingException e) {
            System.out.println("[!] Erro ao processar JSON");
        }

        return conjuntoImagens.getConteudos();
    }
}
