package br.com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cidade")
public class Cidade extends EntityGenerica{

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_cidade",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_cidade",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_cidade")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "O nome é obrigatório.")
    @Size(min = 5,max = 50 ,message = "O nome deve possuir entre 5 e 50 caracteres.")
    @Column(name = "nome")
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
