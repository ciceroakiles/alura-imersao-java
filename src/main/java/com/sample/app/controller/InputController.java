package com.sample.app.controller;

import java.util.Scanner;

import com.sample.app.repository.FilmeRepository;

public class InputController {
    
    public static void inputLoop() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        do {
            System.out.println("(-1: sair) Index [1-250]:");
            try {
                i = Integer.parseInt(sc.next());
                if (i == -1) break;
                System.out.println("\n" + FilmeRepository.getFilmes().get(i-1) + "\n");
            } catch (Exception e) {
                i = 0;
            }
        } while (i != -1);
        sc.close();
    }
}
