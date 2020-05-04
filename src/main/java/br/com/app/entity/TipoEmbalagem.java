package br.com.app.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tipo_embalagem")
public class TipoEmbalagem extends EntityGenerica{

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_tipo_embalagem",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_tipo_embalagem",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_tipo_embalagem")
    @Column(name="id")
    private Long id;

    @NotNull(message="A descrição é obrigatória.")
    @Length(max = 30 , message = "Descrição deve possuir no maxímo 30 caracteres.")
    @Column(name="descricao")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
