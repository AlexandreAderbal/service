package br.com.app.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "produto")
public class Produto extends EntityGenerica {

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_produto",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_produto",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_produto")
    @Column(name="ID")
    protected Long id;

    @NotNull(message="O codigo não pode ser null.")
    @Length(max=10 ,message="O codigo não pode conter mais de 10 caracteres.")
    @Column(name="CODIGO")
    private String codigo;

    @Length(max=100 ,message="O nome tem mais de 100 caracteres.")
    @Column(name="NOME")
    private String nome;

    @Length(max=20 ,message="A embalagem tem mais de 20 caracteres.")
    @Column(name="EMBALAGEM", length=20)
    private String embalagem;

    @Length(max=20 ,message="O Codigo de fabrica tem mais de 20 caracteres.")
    @Column(name="CFABRICA", length=20)
    private String codigoFabrica;

    @Column(name="VOLUMES")
    private Double volumes;

    @Column(name="SHELFLIFE")
    private Double shelfLife;

    @Column(name="NOTIF_SHELFLIFE")
    private Double percentualShelfLife;

    @Column(name="CONTROLE_TEMPERATURA", length=1)
    private boolean controleTemperatura;

    @Column(name="TEMP_MIN")
    private Double temperaturaMinima;

    @Column(name="TEMP_MAX")
    private Double temperaturaMaxima;

    @Column(name="EXISTE_CBARRA", length=1)
    private boolean existeCodigoBarra;

    @Column(name="CONTROLE_LOTE", length=1)
    private boolean controleLote;

    @Column(name="CONTROLE_VENCTO", length=1)
    private boolean controleVencto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public String getCodigoFabrica() {
        return codigoFabrica;
    }

    public void setCodigoFabrica(String codigoFabrica) {
        this.codigoFabrica = codigoFabrica;
    }

    public Double getVolumes() {
        return volumes;
    }

    public void setVolumes(Double volumes) {
        this.volumes = volumes;
    }

    public Double getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Double shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Double getPercentualShelfLife() {
        return percentualShelfLife;
    }

    public void setPercentualShelfLife(Double percentualShelfLife) {
        this.percentualShelfLife = percentualShelfLife;
    }

    public boolean isControleTemperatura() {
        return controleTemperatura;
    }

    public void setControleTemperatura(boolean controleTemperatura) {
        this.controleTemperatura = controleTemperatura;
    }

    public Double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(Double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public Double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(Double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public boolean isExisteCodigoBarra() {
        return existeCodigoBarra;
    }

    public void setExisteCodigoBarra(boolean existeCodigoBarra) {
        this.existeCodigoBarra = existeCodigoBarra;
    }

    public boolean isControleLote() {
        return controleLote;
    }

    public void setControleLote(boolean controleLote) {
        this.controleLote = controleLote;
    }

    public boolean isControleVencto() {
        return controleVencto;
    }

    public void setControleVencto(boolean controleVencto) {
        this.controleVencto = controleVencto;
    }
}
