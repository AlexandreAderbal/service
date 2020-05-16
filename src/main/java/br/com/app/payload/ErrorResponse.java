package br.com.app.payload;

import java.io.Serializable;
import java.util.List;

public class ErrorResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final int codigo;
    private final String status;
    private final String objeto;
    private final String endPoint;
    private final List<ErrorDetails> errors;

    public ErrorResponse(String message,
                         int codigo,
                         String status,
                         String objeto,
                         List<ErrorDetails> errors,
                         String endPoint) {
        this.message = message;
        this.codigo = codigo;
        this.status = status;
        this.objeto = objeto;
        this.errors = errors;
        this.endPoint = endPoint;
    }

    public String getMessage() {
        return message;
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

    public String getEndPoint() {
        return endPoint;
    }
}
