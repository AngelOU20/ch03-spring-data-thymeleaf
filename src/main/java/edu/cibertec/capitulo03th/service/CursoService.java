package edu.cibertec.capitulo03th.service;

import edu.cibertec.capitulo03th.dao.CursoDAO;
import edu.cibertec.capitulo03th.dao.entity.CursoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoDAO cursoDAO;

    @Override
    public List<CursoEntity> consultarPorEstado(int estado) {
        return cursoDAO.consultarPorEstado(estado);
    }

    @Override
    public List<CursoEntity> consultarAbiertoIncompleto() {
        return cursoDAO.abiertoIncompleto();
    }

    @Override
    public List<CursoEntity> consultarPorFecha(Date fecha) {
        return cursoDAO.consultarPorFecha(fecha);
    }

    @Override
    public List<CursoEntity> consultarFaltantes(Integer cantidad) {
        return cursoDAO.consultarFaltantes(cantidad);
    }

    @Override
    public List<CursoEntity> consultarPorNombre(String cadena) {
        return cursoDAO.consultarPorNombre(cadena);
    }
}
