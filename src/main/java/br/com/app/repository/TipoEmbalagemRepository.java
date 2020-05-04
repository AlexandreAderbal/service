package br.com.app.repository;

import br.com.app.entity.TipoEmbalagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEmbalagemRepository extends JpaRepository<TipoEmbalagem,Long> {
}
