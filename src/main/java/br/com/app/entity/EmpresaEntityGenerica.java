package br.com.app.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class EmpresaEntityGenerica extends EntityGenerica {

    @NotNull(message="O Tipo de documento deve ser informado.")
    @Enumerated(EnumType.STRING)
    @Column(name="TP_DOC")
    private TpDoc tpDoc;

    public enum TpDoc{
        CPF("CPF"),
        CNPJ("CNPJ");

        String tpDoc;

        private TpDoc (String tpDoc){
            this.tpDoc=tpDoc;
        }
    }

    @NotNull(message="O número documento deve ser informado.")
    @Size(min = 11 , message = "Quantidade de caracteres insuficiente do campo CPF/CNPJ .")
    @Column(name="CGC")
    private String cgc;

    @Size(max = 20 , message = "Inscrição Estadual muito grande.")
    @Column(name="IE")
    private String ie;

    @NotNull(message="O nome deve ser informado.")
    @Size(max = 100, message = "Nome muito grande.")
    @Column(name="NOME")
    private String nome;

    @Column(name="FANTASIA", length=100)
    private String fantasia;

    public TpDoc getTpDoc() {
        return tpDoc;
    }

    public void setTpDoc(TpDoc tpDoc) {
        this.tpDoc = tpDoc;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }
}
