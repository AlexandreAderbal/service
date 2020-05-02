package br.com.app.payload;

import br.com.app.entity.Permissao;

import java.util.List;

public class ListaPermissao {

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