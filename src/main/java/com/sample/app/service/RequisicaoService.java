package com.sample.app.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoService {
    
    public static String fazerRequisicao(String url) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
        String result = "";
        try {
            result = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString())
                .body();
        } catch (IOException | InterruptedException e1) {
            System.out.println("[!] Erro ao processar a requisicao");
        }
        return result;
    }
}
