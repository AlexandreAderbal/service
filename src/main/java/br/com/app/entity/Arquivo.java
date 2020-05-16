package br.com.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "arquivo")
public class Arquivo extends EntityGenerica{

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_arquivo",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_arquivo",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_arquivo")
    @Column(name = "id")
    private Long id;

    @NotNull(message = "O nome é obrigatótio")
    @Size(min= 5 , max = 500, message = "O nome deve possuír entre 5 e 500 caracteres")
    @Column(name = "nome")
    private String nome;

    @NotNull(message = "O nome é obrigatótio")
    @Size( max = 10, message = "A descrição deve possuír no máximo 10 caracteres")
    @Column(name = "tipo")
    private String tipo;

    @NotNull(message = "O arquivo é obrigatótio")
    @Column(name = "arquivo")
    private Byte[] arquivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Chamado chamado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private ChamadoAlteracao chamadoAlteracao;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(Byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public ChamadoAlteracao getChamadoAlteracao() {
        return chamadoAlteracao;
    }

    public void setChamadoAlteracao(ChamadoAlteracao chamadoAlteracao) {
        this.chamadoAlteracao = chamadoAlteracao;
    }
}
