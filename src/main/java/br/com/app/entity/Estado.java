package br.com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estado")
public class Estado extends EntityGenerica{

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_estado",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_estado",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_estado")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "O código é obrigatório.")
    @Column(name = "codigo")
    private Long codigo;

    @NotNull(message = "O nome é obrigatório.")
    @Size(min = 5,max = 50 ,message = "O nome deve possuir entre 5 e 50 caracteres.")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "A sigle é obrigatório.")
    @Size(min = 2,max = 2 ,message = "A sigle deve possuir 2 caracteres.")
    @Column(name = "sigla")
    private String sigla;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "estado")
    private Set<Cidade> cidades = new HashSet<Cidade>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Set<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(Set<Cidade> cidades) {
        this.cidades = cidades;
    }
}
