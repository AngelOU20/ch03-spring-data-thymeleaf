package edu.cibertec.capitulo03th.service;

import edu.cibertec.capitulo03th.dao.UsuarioDAO;
import edu.cibertec.capitulo03th.dao.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UsuarioEntity validarLogin(UsuarioEntity usuario) {
        UsuarioEntity rpta = usuarioDAO.findByUsuarioAndClave
                (usuario.getUsuario(), usuario.getClave());
        return rpta;
    }

    @Override
    public void insertarUsuario(UsuarioEntity usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public List<UsuarioEntity> getListaUsuarios() {
        return usuarioDAO.findAll();
    }

    @Override
    public List<UsuarioEntity> getListaUsuarios(Pageable pagina) {
        return usuarioDAO.findAll(pagina).getContent();
    }

    @Override
    public void eliminarUsuario(UsuarioEntity usuario) {
        usuarioDAO.delete(usuario);
    }
}
