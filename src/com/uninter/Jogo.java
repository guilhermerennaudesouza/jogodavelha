/*
*Preferi organizar o jogo com pacotes, utilizei o arquivo disponibilizado no Painel AVA da UNINTER
*como base, criei o arquivo de Jogo dentro do pacote que ja estava criado no mesmo, criei um pacote para
*tudo relacionado a jogadas, incluindo jogador, computador e usuario, outro pacote para tudo relacionado
*ao tabuleiro como a siutuacao atual de jogo e o proprio tabuleiro.
*/
package com.uninter;
 

import com.uninter.jogador.Computador;
import com.uninter.jogador.Usuario;
import com.uninter.factory.ComputadorFactory;
import com.uninter.tabuleiro.Situacao;
import com.uninter.tabuleiro.Tabuleiro;

import java.util.Scanner;

public class Jogo {
/*Criada uma instancia da Classe Tabuleiro 
 * Inserido Scanner para input do teclado no console
 * Solicitado para que o jogador selecione uma dificuldade valida entre 1-3,
 * cada qual com padroes de jogada diferentes
 * Definida uma boolean para verificar se a vez do Usuario/Jogador é verdadeira, caso falso
 * chama função jogar para que o computador tenha sua vez.
 * Foram definidas situações na classe Situacao para que fosse mais facil de organizar essa
 * parte do codigo.
 */
	public static void main(String[] args) {
		Tabuleiro tabulerio = new Tabuleiro();

		Scanner teclado = new Scanner(System.in);

		System.out.println("Jogo da velha");
		System.out.println("Escolha a dificuldade 1,2 ou 3:");
		int opcao = teclado.nextInt();

		while(opcao < 1 || opcao > 3) {
			System.out.println("Jogo da velha");
			System.out.println("Escolha a dificuldade 1,2 ou 3:");
			opcao = teclado.nextInt();
		}

		Usuario jogador = new Usuario();
		final Computador computador = ComputadorFactory.getComputador(opcao);

		tabulerio.visualizar();

		boolean vezUsuario = true;
		while(tabulerio.getSituacao() == Situacao.JOGANDO) {

			if(vezUsuario) {
				jogador.jogar(tabulerio);
				vezUsuario = false;
				System.out.println("Vez do usuário");
			} else {
				computador.jogar(tabulerio);
				vezUsuario = true;
				System.out.println("Vez do computador");
			}

			tabulerio.visualizar();

			System.out.println();
		}

		System.out.println("Situação do jogo:" + tabulerio.getSituacao().getMensagem());
	}
}
