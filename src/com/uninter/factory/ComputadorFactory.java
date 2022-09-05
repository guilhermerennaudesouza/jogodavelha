package com.uninter.factory;

import com.uninter.jogador.Computador;
import com.uninter.jogador.ComputadorDificil;
import com.uninter.jogador.ComputadorFacil;
import com.uninter.jogador.ComputadorMedio;
/*
 * Criado Classe para definirmos a dificuldade do Computador
 */
public class ComputadorFactory {

    private static final int FACIL = 1;
    private static final int MEDIO = 2;
    private static final int DIFICIL = 3;

    public static Computador getComputador(int opcao) {
        Computador computador = null;

        if(opcao == FACIL) {
            computador = new ComputadorFacil();
        } else if (opcao == MEDIO) {
            computador = new ComputadorMedio();
        } else if (opcao == DIFICIL) {
            computador = new ComputadorDificil();
        }

        return computador;
    }
}
