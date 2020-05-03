package br.com.app.payload;

import java.io.Serializable;

public class ErrorDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;
    private String details;

    public ErrorDetails(String message, String details) {
        super();
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
