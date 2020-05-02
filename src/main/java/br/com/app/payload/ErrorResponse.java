package br.com.app.payload;

import java.util.List;

public class ErrorResponse {

    private final String mensagem;
    private final int codigo;
    private final String status;
    private final String objeto;
    private final List<ErrorDetails> errors;

    public ErrorResponse(String mensagem, int codigo, String status, String objeto, List<ErrorDetails> errors) {
        this.mensagem = mensagem;
        this.codigo = codigo;
        this.status = status;
        this.objeto = objeto;
        this.errors = errors;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public String getObjeto() {
        return objeto;
    }

    public List<ErrorDetails> getErrors() {
        return errors;
    }
}
