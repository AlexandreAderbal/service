package br.com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chamado")
public class Chamado extends EntityGenerica{

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_chamado",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_chamado",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_chamado")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "O título é obrigatótio")
    @Size(min= 5 , max = 500, message = "O título deve possuír entre 5 e 500 caracteres")
    @Column(name = "titulo")
    private String titulo;

    @NotNull(message = "O descrição é obrigatótio")
    @Size(min = 10, max = 8000, message = "A descrição deve possuír entre 10 e 8000 caracteres")
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private Date data;

    @ManyToOne
    @JoinColumn(name="id_departamento")
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name="id_atendente")
    private Usuario atendente;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Usuario cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "chamado")
    private Set<Arquivo> arquivos = new HashSet<Arquivo>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "chamado")
    private Set<ChamadoAlteracao> chamadoAlteracoes = new HashSet<ChamadoAlteracao>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Usuario getAtendente() {
        return atendente;
    }

    public void setAtendente(Usuario atendente) {
        this.atendente = atendente;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Set<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(Set<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public Set<ChamadoAlteracao> getChamadoAlteracoes() {
        return chamadoAlteracoes;
    }

    public void setChamadoAlteracoes(Set<ChamadoAlteracao> chamadoAlteracoes) {
        this.chamadoAlteracoes = chamadoAlteracoes;
    }
}
