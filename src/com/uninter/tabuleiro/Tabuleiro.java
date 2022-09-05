package com.uninter.tabuleiro;

public class Tabuleiro {
/*Definido matriz de 3*3 para simular o jogo da velha no console
 * Definido o valor int dos espaçoes e seus equivalentes para facilitar no desenvolvimento do codigo
 * para que nao seja necessario utilizar 0, 1 e -1 para representar.
 */
	private static final int ESPACO_VAZIO = 0;
	private static final int X = 1;
	private static final int O = -1;

	private int matriz[][] = new int[3][3];
/*
 * Verifica se a situação atual do jogo é JOGANDO e verifica a Linha e Coluna
 * Caso todas as linhas e colunas estiverem preenchidas verifica situacao de empate
 */
	public Situacao getSituacao() {
		for(int i = 0; i < 3; i++) {
			Situacao situacao = verificaLinha(i);
			if(situacao != Situacao.JOGANDO) return situacao;

			situacao = verificaColuna(i);
			if(situacao != Situacao.JOGANDO) return situacao;

		}

		final Situacao situacao = verificaDiagonal();

		return situacao != Situacao.JOGANDO ? situacao : verificaEmpate();
	}
/*
 * Logica para verificação de espaços vazios para verificar empate
 */
	private Situacao verificaEmpate() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matriz[i][j] == ESPACO_VAZIO) {
					return Situacao.JOGANDO;
				}
			}
		}
		return Situacao.EMPATE;
	}
/*
 * Logica para verificação das duas opcoes de vitoria em Diagonal (2 Opcoes)
 */
	private Situacao verificaDiagonal() {
		int preenchido = matriz[0][0] + matriz[1][1] + matriz[2][2];
		Situacao situacao = getSituacaoByIndice(preenchido);

		if(situacao != Situacao.JOGANDO) {
			return situacao;
		} else {
			preenchido = matriz[0][2] + matriz[1][1] + matriz[2][0];
			situacao = getSituacaoByIndice(preenchido);
		}

		return situacao;
	}
/*
 * Logica para verificar vitoria por colunas (3 Opcoes)
 */
	private Situacao verificaColuna(int indice) {
		int preenchido = 0;

		for(int i = 0; i < 3; i++){
			preenchido += matriz[i][indice];
		}

		return getSituacaoByIndice(preenchido);
	}
/*
 * Logica para verificar vitoria por linhas (3 Opcoes)
 */
	private Situacao verificaLinha(int indice) {
		int preenchido = 0;

		for(int i = 0; i < 3; i++){
			preenchido += matriz[indice][i];
		}

		return getSituacaoByIndice(preenchido);
	}
/*
 * Verifica a situacao por indice e retorna com resultado Final, Vitoria, Derrota ou Empate.
 * Caso ainda esteja na situacao Jogando repete o codigo
 */
	private Situacao getSituacaoByIndice(int preenchido) {
		if(preenchido == -3) {
			return Situacao.COMPUTADOR_VENCEU;
		} else if (preenchido == 3) {
			return Situacao.USUARIO_VENCEU;
		} else {
			return Situacao.JOGANDO;
		}
	}
/*
 * Definida uma unica Boolean adicionamatriz que verifica a jogada e será utilizada na classe Usuario,
 * ComputadorFacil, ComputadorMedio, ComputadorDificil para que o loop ocorra sem erro e permita que 
 * a jogada seja efetuada novamente por eles caso esteja invalida.
 */
	public boolean adicionaMatriz(int linha, int coluna, int valor){
		if(matriz[linha][coluna] == ESPACO_VAZIO) {
			matriz[linha][coluna] = valor;
			return true;
		} else {
			System.out.println("Jogada inválida");
			return false;
		}
	}
/*
 * Definido a vizualizaçao dos vetores no console para ver progresso do Jogo.	
 */
	public void visualizar() {
		for (int i = 0; i < matriz.length; i++) {

			for (int j = 0; j < matriz.length; j++) {

				if(matriz[i][j] == X) {
					System.out.print("X ");
				}
				else if(matriz[i][j] == O) {
					System.out.print("O ");
				}
				else {
					System.out.print("- ");
				}
			}

			System.out.println();
		}
	}
}
