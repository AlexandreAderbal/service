package br.com.app.entity;

import br.com.app.enums.PermissaoEnum;
import br.com.app.enums.TipoPermissaoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="permissao")
@JsonIgnoreProperties({"usuarios"})
public class Permissao extends EntityGenerica {

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_permissao",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_permissao",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_permissao")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Nome é obrigatório.")
    @Column(name = "nome")
    @Enumerated(EnumType.STRING)
    private PermissaoEnum nome;

    @NotNull(message = "Tipo da permissão é obrigatótio.")
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoPermissaoEnum tipo;

    @NotBlank(message = "Descrição é obrigatótio.")
    @Size(min = 3 ,max = 100 ,message = "Descrição deve possuir entre 3 e 20 caracteres.")
    @Column(name = "descricao")
    private String descricao;

    @ManyToMany(mappedBy = "permissoes")
    private Set<Usuario> usuarios = new HashSet<Usuario>();

    @Transient
    private boolean selecionado = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PermissaoEnum getNome() {
        return nome;
    }

    public void setNome(PermissaoEnum nome) {
        this.nome = nome;
    }

    public TipoPermissaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoPermissaoEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
}
