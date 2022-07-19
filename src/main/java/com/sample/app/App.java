package com.sample.app;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.app.controller.InputController;
import com.sample.app.model.Filme;
import com.sample.app.repository.FilmeRepository;
import com.sample.app.service.RequisicaoService;
//import com.sample.app.utils.PropertyManager;

public class App {
    
    //private static final String url1 = "https://api.mocki.io/v2/" + PropertyManager.getApiKey("dev.properties") + "/MostPopularMovies";
    private static final String url2 = "https://alura-filmes.herokuapp.com/conteudos";

    static List<Filme> filmes;
    
    public static void main(String[] args) throws Exception {
        String json = RequisicaoService.fazerRequisicao(url2);
        
        ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        JsonNode node = mapper.readTree(json);
        String dados = node.get("items").toString();
        
        FilmeRepository.setFilmes(Arrays.asList(mapper.readValue(dados, Filme[].class)));

        InputController.inputLoop();
    }
}
