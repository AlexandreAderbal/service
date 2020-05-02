package br.com.app.repository;

import br.com.app.entity.Permissao;
import br.com.app.enums.TipoPermissaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Long> {
    List<Permissao> findByTipo(TipoPermissaoEnum usuario);
}
