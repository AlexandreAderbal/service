package br.com.app.payload;

import br.com.app.entity.Permissao;

import java.io.Serializable;
import java.util.List;

public class ListaPermissao implements Serializable {

    private static final long serialVersionUID = 1L;

    private String titulo;
    private List<Permissao> permissoes;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}