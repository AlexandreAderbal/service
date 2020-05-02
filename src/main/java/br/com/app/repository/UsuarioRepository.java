package br.com.app.repository;

import br.com.app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String email);

    @Query(value="update Usuario set Usuario.senha = :p1 where Usuario.id = :p2",nativeQuery = true)
    void updateSenha(@Param("p1") String senha, @Param("p2") Long id);

}
