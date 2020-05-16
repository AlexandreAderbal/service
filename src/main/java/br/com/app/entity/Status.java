package br.com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "status")
public class Status extends EntityGenerica{
    
    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_status",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_status",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_status")
    @Column(name="ID")
    protected Long id;

    @NotNull(message = "A descrição é obrigatória!")
    @Size(min = 5 ,max = 50 ,message = "A descrição deve ter entre 5 e 50 caracteres!")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo")
    private Boolean ativo = Boolean.TRUE;

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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
}
