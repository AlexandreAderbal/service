package br.com.app.enums;

public enum TipoDocumento {

    CPF("CPF"),
    CNPJ("CNPJ");

    String tpDoc;

    TipoDocumento (String tpDoc){
        this.tpDoc=tpDoc;
    }


}
