package com.sample.app.controller;

import java.util.Scanner;

import com.sample.app.model.Filme;
import com.sample.app.repository.FilmeRepository;
import com.sample.app.utils.DetectOS;
import com.sample.app.utils.StickerManager;

public class InputOutputController {
    
    private static Scanner sc = new Scanner(System.in);
    private static StickerManager stm = new StickerManager();
    private static Filme filme;

    public static void filmesInputLoop() {
        int i = 0, qtde = FilmeRepository.getFilmes().size();
        do {
            System.out.println("[!] Quantidade de filmes no catalogo: " + qtde);
            System.out.println("[?] Escolha um: [1-" + qtde + "] (-1: sair)");
            try {
                i = Integer.parseInt(sc.next());
                if (i != -1) {
                    filme = FilmeRepository.getFilmes().get(i-1);
                    avaliacaoInputLoop();
                } else break;
            } catch (Exception e) {
                i = 0;
            }
        } while (i != -1);
        sc.close();
    }

    private static void avaliacaoInputLoop() {
        sc.nextLine();
        System.out.println("\n" + filme + " " + notaCount((int) Double.parseDouble(filme.getImDbRating())));
        String avalConfirm;
        do {
            System.out.println("[?] Deseja mudar a avaliacao? [s/n]");
            avalConfirm = sc.nextLine().toLowerCase();
            if (avalConfirm.equals("s")) {
                System.out.println("[!] Uma figurinha sera gerada.");
                mudarAvaliacaoLoop();
            }
        } while (!avalConfirm.equals("s") && !avalConfirm.equals("n"));
    }

    private static void mudarAvaliacaoLoop() {
        Double novaNota = -1.0;
        do {
            System.out.println("[?] Nova avaliacao: [0.0-10.0]");
            try {
                novaNota = Double.parseDouble(sc.next());
                if (novaNota >= 0.0 && novaNota <= 10.0) break;
            } catch (Exception e) {
                novaNota = -1.0;
            }
        } while (novaNota == -1.0);

        filme.setImDbRating(novaNota.toString());
        //System.out.println("[!] Gerando imagem da figurinha...");
        stm.criarFigurinha(filme, legendaNota(novaNota));
        System.out.println("[!] Imagem gerada com sucesso.\n");
    }

    private static String notaCount(int nota) {
        StringBuilder sb = new StringBuilder();
        String star = DetectOS.starChar();
        for (int i = 0; i < nota; i++) {
            sb.append(" " + star);
        }
        return sb.toString();
    }

    private static String legendaNota(Double nota) {
        return (nota >= 9) ? "TOPZERA!" : 
            (nota >= 7.25) ? "MUITO BOM!" :
            (nota >= 5.5) ? "MAIS OU MENOS!" :
            (nota >= 2.75) ? "DORMI NO MEIO!" :
            "NEM VI!";
    }
}
