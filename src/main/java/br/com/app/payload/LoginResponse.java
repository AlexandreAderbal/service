package br.com.app.payload;

import br.com.app.entity.Usuario;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;
    private Usuario usuario;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
