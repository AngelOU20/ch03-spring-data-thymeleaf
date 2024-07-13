package edu.cibertec.capitulo03th.controller;

import edu.cibertec.capitulo03th.dao.entity.UsuarioEntity;
import edu.cibertec.capitulo03th.service.UsuarioService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("contador")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("loginMostrar")
    public String loginMostrar() {
        return "login";
    }

    @RequestMapping("loginAccion")
    public ModelAndView loginAccion(UsuarioEntity usuarioValida) {
        ModelAndView mv = null;
        UsuarioEntity ue = usuarioService.validarLogin(usuarioValida);
        if (ue == null) {
            mv = new ModelAndView("login", "msgError", "Usuario y clave no existen. Vuelva a intentar!");
        } else {
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
            mv.addObject("contador", 0);
        }
        return mv;
    }

    @RequestMapping("usuarioCrear")
    public ModelAndView crearUsuario() {
        ModelAndView mv = new ModelAndView("usuarioDatos", "usuarioBean", new UsuarioEntity());
        mv.addObject("accion", "Insertar");
        return mv;
    }

    @RequestMapping("usuarioGrabar")
    public ModelAndView grabarUsuario(@RequestParam("archivo") CommonsMultipartFile foto, @Valid @ModelAttribute("usuarioBean") UsuarioEntity usuario, BindingResult resulta, ModelMap modelo) {
        ModelAndView mv = null;
        if (resulta.hasErrors()) {
            mv = new ModelAndView("usuarioDatos", "usuarioBean", usuario);
        } else {
        // La foto se recibe con otro nombre de parámetro para que pase la validación, ya que sino
        // arroja el error por el tipo de dato (comparándolo con el del Entity)
            usuario.setFoto(foto.getBytes());
            usuarioService.insertarUsuario(usuario);
            mv = new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
            int contador = (int) modelo.get("contador");
            contador++;
            mv.addObject("contador", contador);
        }
        return mv;
    }

    @RequestMapping("usuarioListar")
    public ModelAndView usuarioListar() {
        return new ModelAndView("usuarioLista", "lista", usuarioService.getListaUsuarios());
    }

//    @RequestMapping("usuarioMod")
//    public ModelAndView usuarioModificar(@RequestParam("codigoUsuario") String codigo) {
//        ModelAndView mv = new ModelAndView("usuarioDatos", "usuarioBean", usuarioService.getUsuario(codigo));
//        mv.addObject("accion", "Modificar");
//        return mv;
//    }

    @RequestMapping("usuarioEliminar")
    public ModelAndView eliminarUsuario(@RequestParam("id") int id) {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(id);
        usuarioService.eliminarUsuario(usuario);
        return new ModelAndView("usuarioLista", "lista",
                usuarioService.getListaUsuarios());
    }
}
