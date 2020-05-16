package br.com.app.enums;

public enum PermissaoEnum {

    ROLE_USUARIO_CONSULTAR("Consultar usuário."),
    ROLE_USUARIO_REGISTRAR("Registrar usuário."),
    ROLE_USUARIO_DELETAR("Deletar usuário."),

    ROLE_PERMISSAO_CONSULTAR("Consultar permissão."),
    ROLE_PERMISSAO_REGISTRAR("Registrar permissão."),
    ROLE_PREMISSAO_DELETAR("Deletar permissão."),

    ROLE_FORNECEDOR_CONSULTAR("Consultar fornecedor."),
    ROLE_FORNECEDOR_REGISTRAR("Registrar fornecedor."),
    ROLE_FORNECEDOR_DELETAR("Deletar fornecedor."),

    ROLE_ESTADO_CONSULTAR("Consultar estador."),
    ROLE_ESTADO_REGISTRAR("Registrar estador."),
    ROLE_ESTADO_DELETAR("Deletar estador."),

    ROLE_CIDADE_CONSULTAR("Consultar cidade."),
    ROLE_CIDADE_REGISTRAR("Registrar cidade."),
    ROLE_CIDADE_DELETAR("Deletar cidade."),

    ROLE_TIPO_EMBALAGEM_CONSULTAR("Consultar tipo embalagem."),
    ROLE_TIPO_EMBALAGEM_REGISTRAR("Registrar tipo embalagem."),
    ROLE_TIPO_EMBALAGEM_DELETAR("Deletar tipo embalagem."),

    ROLE_PRODUTO_CONSULTAR("Consultar produto."),
    ROLE_PRODUTO_REGISTRAR("Registrar produto."),
    ROLE_PRODUTO_DELETAR("Deletar produto.");

    private String value;

    PermissaoEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
