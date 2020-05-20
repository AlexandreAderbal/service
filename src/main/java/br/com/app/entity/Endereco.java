package br.com.app.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco extends EntityGenerica{

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_endereco",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_endereco",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_endereco")
    @Column(name = "id")
    private Long id;

    @Email(message = "Informe um email válido!")
    @Column(name = "email")
    private String email;

    @NotNull(message = "O ddd é obrigatório!")
    @Column(name = "ddd")
    private Integer ddd;

    @NotNull(message = "O telefone é obrigatório")
    @Column(name = "telefone")
    private Integer telefone;

    @NotNull(message = "O cep é obrigatório")
    @Column(name = "cep")
    private Integer cep;

    @Size(max = 250 , message = "A rua deve possuír no máximo 250 caracteres")
    @Column(name = "rua")
    private String rua;

    @Size(max = 250 , message = "O bairro deve possuír no máximo 250 caracteres")
    @Column(name = "bairro")
    private String bairro;

    @Size(max = 500 , message = "O complemento deve possuír no máximo 500 caracteres")
    @Column(name = "complemento")
    private String complemento;

    @Size(max = 100 , message = "O logradouro deve possuír no máximo 100 caracteres")
    @Column(name = "logradouro")
    private String logradouro;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="id_cidade")
    private Cidade cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}

