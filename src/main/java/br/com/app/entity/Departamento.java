package br.com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "departamento")
public class Departamento extends EntityGenerica{

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_departamento",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_departamento",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_departamento")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "O nome é obrigatótio")
    @Size(max = 250, message = "O nome deve possuír no máximo 250 caracteres")
    @Column(name = "nome")
    private String nome;

    @Size(max = 250, message = "A descrição deve possuír no máximo 250 caracteres")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo")
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresa empresa;

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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
