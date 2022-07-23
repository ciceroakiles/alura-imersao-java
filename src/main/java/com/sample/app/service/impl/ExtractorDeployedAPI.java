package com.sample.app.service.impl;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.app.model.Conteudo;
import com.sample.app.repository.ConteudoRepository;
import com.sample.app.service.IExtractor;

public class ExtractorDeployedAPI implements IExtractor {

    @Override
    public List<Conteudo> extrairConteudos(String json) {
        ConteudoRepository conjuntoImagens = new ConteudoRepository();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(json);
            for (JsonNode item: root) {
                Conteudo c = new Conteudo();
                c.setTitle(item.get("title").asText());
                c.setImage(item.get("image").asText());
                conjuntoImagens.addConteudo(c);
            }
        } catch (Exception e) {
            System.out.println("[!] Erro ao processar JSON");
        }
        return conjuntoImagens.getConteudos();
    }
    
}
