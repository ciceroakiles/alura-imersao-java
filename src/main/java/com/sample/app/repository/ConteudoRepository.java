package com.sample.app.repository;

import java.util.ArrayList;
import java.util.List;

import com.sample.app.model.Conteudo;

public class ConteudoRepository {
    
    private List<Conteudo> listaConteudos = new ArrayList<>();

    public void addConteudo(Conteudo... conteudos) {
        for (Conteudo c: conteudos) {
            listaConteudos.add(c);
        }
    }

    public List<Conteudo> getConteudos() {
        return listaConteudos;
    }
}
