package br.com.app.entity;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Table(name = "empresa")
public class Empresa extends EntityGenerica {

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_empresa",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_empresa",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_empresa")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "O nome é obrigatótio")
    @Size(max = 250, message = "O nome deve possuír no máximo 250 caracteres")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "O cnpj é obrigatótio")
    @CNPJ(message = "Informe um cnpj válido.")
    private String cnpj;

    @Size(max = 250, message = "A descrição deve possuír no máximo 250 caracteres")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name="id_endereco")
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
