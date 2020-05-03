package br.com.app.entity;

import br.com.app.enums.CoresTemas;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="layout")
public class Layout extends EntityGenerica {

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_layout",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_layout",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_layout")
    @Column(name = "id")
    private Long id;

    @Column(name="barra_navegacao_fixa")
    private boolean barraNavegacaoFixa = true;

    @Column(name="layout_fixo")
    private boolean layoutFixo = false;

    @Column(name="recolher_barra_lateral")
    private boolean recolherBarraLateral = false;

    @Column(name="cor_tema")
    @Enumerated(EnumType.ORDINAL)
    private CoresTemas corTema = CoresTemas.standard;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isBarraNavegacaoFixa() {
        return barraNavegacaoFixa;
    }

    public void setBarraNavegacaoFixa(boolean barraNavegacaoFixa) {
        this.barraNavegacaoFixa = barraNavegacaoFixa;
    }

    public boolean isLayoutFixo() {
        return layoutFixo;
    }

    public void setLayoutFixo(boolean layoutFixo) {
        this.layoutFixo = layoutFixo;
    }

    public boolean isRecolherBarraLateral() {
        return recolherBarraLateral;
    }

    public void setRecolherBarraLateral(boolean recolherBarraLateral) {
        this.recolherBarraLateral = recolherBarraLateral;
    }

    public CoresTemas getCorTema() {
        return corTema;
    }

    public void setCorTema(CoresTemas corTema) {
        this.corTema = corTema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
