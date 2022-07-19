package com.sample.app.utils;

import java.io.IOException;
import java.util.Properties;

import com.sample.app.App;

public class PropertyManager {
    
    public static String getApiKey(String path) {
        Properties prop = new Properties();
        try {
            prop.load(App.class
                .getClassLoader()
                .getResourceAsStream(path)
            );
        } catch (IOException e) {
            System.out.println("[!] Arquivo de configuracao nao encontrado");
        }
        return prop.getProperty("API_KEY").toString();
    }
}
