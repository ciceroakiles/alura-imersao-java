package com.sample.app.utils;

import java.io.File;

public class FileHandler {
    
    public File gerarArquivo(String nome) {
        String path = "out/";
        File arquivo = new File(path + nome.replaceAll("\\P{Alnum}", "_") + ".png");
        
        if (!arquivo.exists()) {
            arquivo.mkdirs();
        } else {
            try {
                arquivo.createNewFile();
            } catch (Exception e) {
                System.out.println("[!] Falha ao criar novo arquivo com o nome " + nome);
            }
        }
        return arquivo;
    }
}
