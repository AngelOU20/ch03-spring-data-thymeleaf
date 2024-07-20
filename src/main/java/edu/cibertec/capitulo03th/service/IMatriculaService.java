package edu.cibertec.capitulo03th.service;

import edu.cibertec.capitulo03th.dao.entity.MatriculaEntity;

import java.util.List;

public interface IMatriculaService {
    List<MatriculaEntity> listaTodas();
    void grabarMatricula(MatriculaEntity me);
}
