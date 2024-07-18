package edu.cibertec.capitulo03th.service;

import edu.cibertec.capitulo03th.dao.entity.CursoEntity;

import java.sql.Date;
import java.util.List;

public interface ICursoService {
    List<CursoEntity> consultarPorEstado(int estado);
    List<CursoEntity> consultarAbiertoIncompleto();
    List<CursoEntity> consultarPorFecha(Date fecha);
    List<CursoEntity> consultarFaltantes(Integer cantidad);
    List<CursoEntity> consultarPorNombre(String cadena);
}
