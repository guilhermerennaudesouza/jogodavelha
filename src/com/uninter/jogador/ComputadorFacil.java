package com.uninter.jogador;

import com.uninter.tabuleiro.Tabuleiro;

import java.util.Random;

public class ComputadorFacil extends Computador {
	/*Criado uma função para que o Computador efetue sua jogada de forma aleatória 
	 * de acordo com a matriz linha e coluna, apos isso criada uma boolean para que 
	 * o resultado seja vefiricado.
	 */
    private static final int O = -1;

    @Override
    public void jogar(Tabuleiro tabuleiro) {
        int linha = new Random().nextInt(3);
        int coluna = new Random().nextInt(3);
        boolean resultado = tabuleiro.adicionaMatriz(linha, coluna, O);
        while (!resultado) {
        	 linha = new Random().nextInt(3);
             coluna = new Random().nextInt(3);
        	 resultado = tabuleiro.adicionaMatriz(linha, coluna, O);
        }
        
    
}
}
