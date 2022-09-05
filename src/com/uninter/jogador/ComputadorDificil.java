package com.uninter.jogador;

import com.uninter.tabuleiro.Tabuleiro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ComputadorDificil extends Computador {
	/*Criado duas ArrayList, uma para colunas e outra para linhas
	 * Adicionado as posiçoes em que o Computador deve inserir O = -1
	 * Definido uma função para que o Computador jogue em ordem sequencial da ArrayList
	 * Caso o Computador tente fazer uma jogada invalida de um campo ja preenchido ele
	 * sinaliza com mensagem de jogada invalida e joga novamente.
	 */

    private final List<Integer> colunas = new ArrayList();
    private final List<Integer> linhas = new ArrayList();
    private static final int O = -1;

    public ComputadorDificil() {
        colunas.add(0);
        colunas.add(1);
        colunas.add(2);
        linhas.add(0);
        linhas.add(1);
        linhas.add(2);
    }

    private int indice = 0;
    
    @Override
    public void jogar(Tabuleiro tabuleiro) {
        Integer coluna = colunas.get(indice);
        Integer linha = linhas.get(indice);
        indice++;
        if (indice >= 3) {
        	indice = 0;
        	
        }

        boolean resultado = tabuleiro.adicionaMatriz(linha, coluna, O);
        while (!resultado) {
        	 coluna = colunas.get(indice);
             linha = linhas.get(indice);
             indice++;
             if (indice >= 3) {
             	indice = 0;
             	
             }
        	resultado = tabuleiro.adicionaMatriz(linha, coluna, O);
    }
    }
}
   

