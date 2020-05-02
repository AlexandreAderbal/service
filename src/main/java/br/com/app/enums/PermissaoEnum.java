package br.com.app.enums;

public enum PermissaoEnum {

    //Tela de usuario
    ROLE_USUARIO_PESQUISAR("Visualizar"),
    ROLE_USUARIO_GRAVAR("Registrar"),
    ROLE_USUARIO_DELETAR("Deletar"),

    //Tela de Permissões
    ROLE_PERMISSAO_PESQUISAR("Visualizar"),
    ROLE_PERMISSAO_GRAVAR("Registrar"),
    ROLE_PREMISSAO_DELETAR("Deletar");

    private String value;

    PermissaoEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
