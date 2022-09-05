package com.uninter.jogador;

import com.uninter.tabuleiro.Tabuleiro;

import java.util.Random;
import java.util.Scanner;

public class Usuario implements Jogador {
/* Classe Usuario implementa a classe Jogador ja que o computador tambem
 * vai utilizar a mesma.
 */
    private static final int X = 1;
/*Definido um Scanner para a jogada do Usuario, onde voce ecolhe a Linha e Coluna dos vetores
 * entre 0 e 2 para fazer sua jogada.
 * Adicionada uma boolean para verificar se resultado é valido, caso nao seja
 * avisa com mensagem e lhe permite jogar novamente.
 */
    @Override
    public void jogar(Tabuleiro tabuleiro) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Linha:");
        int linha = teclado.nextInt();
        System.out.println("Coluna:");
        int coluna = teclado.nextInt();

        boolean resultado = tabuleiro.adicionaMatriz(linha, coluna, X);
        while (!resultado) {
        	System.out.println("Linha:");
            linha = teclado.nextInt();
            System.out.println("Coluna:");
            coluna = teclado.nextInt();       	
       	 resultado = tabuleiro.adicionaMatriz(linha, coluna, X);
       }
    }
}
