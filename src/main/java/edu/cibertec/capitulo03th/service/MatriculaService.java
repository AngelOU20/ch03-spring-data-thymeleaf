package edu.cibertec.capitulo03th.service;

import edu.cibertec.capitulo03th.dao.MatriculaDAO;
import edu.cibertec.capitulo03th.dao.entity.MatriculaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService implements IMatriculaService {

    @Autowired
    private MatriculaDAO matriculaDAO;

    @Override
    public List<MatriculaEntity> listaTodas() {
        return matriculaDAO.findAll();
    }

    @Override
    public void grabarMatricula(MatriculaEntity me) {
        matriculaDAO.save(me);
    }

}
