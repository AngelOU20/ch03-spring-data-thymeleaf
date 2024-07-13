package edu.cibertec.capitulo03th.service;

import edu.cibertec.capitulo03th.dao.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    UsuarioEntity validarLogin(UsuarioEntity usuario);
    void insertarUsuario(UsuarioEntity usuario);
    List<UsuarioEntity> getListaUsuarios();
    void eliminarUsuario(UsuarioEntity usuario);
}
