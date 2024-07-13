package edu.cibertec.capitulo03th.service;

import edu.cibertec.capitulo03th.dao.UsuarioDAO;
import edu.cibertec.capitulo03th.dao.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public UsuarioEntity validarLogin(UsuarioEntity usuario) {
        Optional<UsuarioEntity> rpta = usuarioDAO.findByUsuario(usuario.getUsuario());
        if (!rpta.isPresent() || !rpta.get().getClave().equals(usuario.getClave())) {
            return null;
        }
        return rpta.get();
    }

    public void insertarUsuario(UsuarioEntity usuario) {
        usuarioDAO.save(usuario);
    }

    public List<UsuarioEntity> getListaUsuarios() {
        return usuarioDAO.findAll();
    }

    public void eliminarUsuario(UsuarioEntity usuario) {
        usuarioDAO.delete(usuario);
    }
}
