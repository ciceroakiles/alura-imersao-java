package com.sample.app.utils;

import java.io.File;
import java.io.IOException;

public class FileManager {
    
    public File gerarArquivo(String nome) {
        String path = "out/";
        File arquivo = new File(path + nome
            .replaceAll("[^a-zA-Z0-9\\.\\-]", "_")
            + ".png");
        
        if (!arquivo.exists()) {
            arquivo.mkdirs();
        } else {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("[!] Falha ao criar novo arquivo");
            }
        }
        return arquivo;
    }
}
