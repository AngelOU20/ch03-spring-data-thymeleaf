package edu.cibertec.capitulo03th.dao;

import edu.cibertec.capitulo03th.dao.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaDAO extends JpaRepository<MatriculaEntity, Integer> {
}
