package br.com.app.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="usuario",
        uniqueConstraints={
            @UniqueConstraint(
                    columnNames={"email","senha","cpf"})
})
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY,generator="usuario_geracao")
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    @Size(max = 200, min = 10 ,message = "Nome deve possuir entre 10 e 200 caracteres.")
    @Column(name="nome")
    private String nome;

    @NotBlank(message = "CPF é obrigatório.")
    @CPF(message = "CPF é inválido.")
    @Column(name="cpf")
    private String cpf;

    @Column(name = "senha",updatable = false)
    private String senha;

    @NotBlank(message = "E-mail é obrigatório.")
    @Size(max =  100, min = 10 ,message = "E-mail deve possuir entre 10 e 100 caracteres.")
    @Email(message = "E-mail é inválido.")
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Layout layout;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_permissao",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_permissao", referencedColumnName = "id"))
    private Set<Permissao> permissoes = new HashSet<Permissao>();

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}


