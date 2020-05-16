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
    @Size(max = 2 , message = "O telefone deve possuír no máximo 9 caracteres")
    @Column(name = "ddd")
    private int ddd;

    @NotNull(message = "O telefone é obrigatório")
    @Size(max = 9 , message = "O telefone deve possuír no máximo 9 caracteres")
    @Column(name = "telefone")
    private int telefone;

    @NotNull(message = "O cep é obrigatório")
    @Size(max = 7 , message = "O telefone deve possuír no máximo 7 caracteres")
    @Column(name = "cep")
    private int cep;

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

    @ManyToOne
    @JoinColumn(name="id_cidade")
    private Cidade cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

