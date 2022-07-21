package com.sample.app.service;

import java.util.List;

import com.sample.app.model.Conteudo;

public interface IExtractor {
    
    public List<Conteudo> extrairConteudos(String json);
}
