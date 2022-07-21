package com.sample.app;

import java.util.List;
import java.util.Scanner;

import com.sample.app.enumerator.UrlExtractorEnum;
import com.sample.app.exception.CustomMsgException;
import com.sample.app.model.Conteudo;
import com.sample.app.utils.ClienteHttp;
import com.sample.app.utils.StickerCreator;

public class App {
    
    public static void main(String[] args) throws Exception {
        List<Conteudo> listaTeste = UrlExtractorEnum.API_IMDB
            .getExtractor()
            .extrairConteudos(
                ClienteHttp.fazerRequisicao(UrlExtractorEnum.API_IMDB.getUrl()
        ));

        System.out.println("Legenda:");
        Scanner scanner = new Scanner(System.in);
        String legenda = scanner.nextLine();
        scanner.close();

        StickerCreator stc = new StickerCreator();
        listaTeste.forEach((content) -> {
            try {
                stc.criarFigurinha(content, legenda);
            } catch (CustomMsgException e) {
                System.out.println(e.getMessage());
            }
        });
    }
}
