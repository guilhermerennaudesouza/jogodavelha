package com.uninter.tabuleiro;
// Definidas Situacoes e mensagens para cada uma delas 
public enum Situacao {

    USUARIO_VENCEU("Usuario Venceu"),
    COMPUTADOR_VENCEU("Computador Venceu"),
    EMPATE("Empate"),
    JOGANDO("Jogando");

    private String mensagem;

    Situacao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
