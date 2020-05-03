package br.com.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends EmpresaEntityGenerica {

    @Id
    @TableGenerator(
            table = "sequences",
            name = "id_fornecedor",
            pkColumnName = "sequence_name",
            valueColumnName = "sequence_next_hi_value",
            pkColumnValue = "id_fornecedor",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_fornecedor")
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
