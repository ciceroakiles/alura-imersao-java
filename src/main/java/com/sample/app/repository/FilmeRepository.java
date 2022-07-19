package com.sample.app.repository;

import java.util.List;

import com.sample.app.model.Filme;

public class FilmeRepository {
    
    private static List<Filme> filmes;

    public static void setFilmes(List<Filme> filmes) {
        FilmeRepository.filmes = filmes;
    }

    public static List<Filme> getFilmes() {
        return FilmeRepository.filmes;
    }
}
