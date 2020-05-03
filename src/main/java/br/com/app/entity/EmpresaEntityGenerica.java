package br.com.app.entity;

import br.com.app.enums.TipoDocumento;

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
    @Column(name="tipo_documento")
    private TipoDocumento tipoDocumento;

    @NotNull(message="O número documento deve ser informado.")
    @Size(min = 11, max = 15 , message = "Quantidade de caracteres insuficiente do campo CPF/CNPJ .")
    @Column(name="numero_documento")
    private String numeroDocumento;

    @Size(max = 20 , message = "Inscrição Estadual muito grande.")
    @Column(name="IE")
    private String ie;

    @NotNull(message="O nome deve ser informado.")
    @Size(max = 100, message = "Nome muito grande.")
    @Column(name="NOME")
    private String nome;

    @Column(name="FANTASIA", length=100)
    private String fantasia;

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
