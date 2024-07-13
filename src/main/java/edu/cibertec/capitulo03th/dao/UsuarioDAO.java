package edu.cibertec.capitulo03th.dao;

import edu.cibertec.capitulo03th.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioDAO extends JpaRepository<UsuarioEntity, Integer> {
    Optional<UsuarioEntity> findByUsuario(String usuario);
}
