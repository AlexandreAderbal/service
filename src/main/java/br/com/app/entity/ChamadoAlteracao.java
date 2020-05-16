package br.com.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chamado_alteracao")
public class ChamadoAlteracao extends EntityGenerica{

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_chamado_alteracao",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_chamado_alteracao",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_chamado_alteracao")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "O nome é obrigatótio")
    @Size(min = 10, max = 8000, message = "A descrição deve possuír entre 10 e 8000 caracteres")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private Date data;

    @ManyToOne
    @JoinColumn(name="id_prioridade")
    private Prioridade prioridade;

    @ManyToOne
    @JoinColumn(name="id_status")
    private Status status;

    @ManyToOne
    @JoinColumn(name="id_departamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name="id_usuario_alteracao")
    private Usuario usuarioAlteracao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "chamadoAlteracao")
    private Set<Arquivo> arquivos = new HashSet<Arquivo>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Chamado chamado;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Usuario getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(Usuario usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public Set<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(Set<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
}
