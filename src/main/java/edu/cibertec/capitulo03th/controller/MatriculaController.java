package edu.cibertec.capitulo03th.controller;

import edu.cibertec.capitulo03th.dao.entity.CursoEntity;
import edu.cibertec.capitulo03th.dao.entity.MatriculaEntity;
import edu.cibertec.capitulo03th.dao.entity.UsuarioEntity;
import edu.cibertec.capitulo03th.service.CursoService;
import edu.cibertec.capitulo03th.service.MatriculaService;
import edu.cibertec.capitulo03th.service.UsuarioService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;
    @Autowired
    private CursoService cursoService;
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("matriculaMostrar")
    public ModelAndView matriculaMostrar() {
        ModelAndView mv = new ModelAndView("matricula", "listaMat", matriculaService.listaTodas());
        mv.addObject("listaUsu", usuarioService.getListaUsuarios());
        mv.addObject("listaCur", cursoService.consultarPorEstado(0));
        return mv;
    }

    @RequestMapping("matriculaGrabar")
    public ModelAndView matriculaGrabar(MatriculaEntity entity,
                                        HttpServletRequest request) {
        CursoEntity ce = new CursoEntity();
        ce.setIdCurso(Integer.parseInt(request.getParameter("cmbCurso")));
        UsuarioEntity ue = new UsuarioEntity();
        ue.setUsuario(request.getParameter("cmbUsuario"));
        entity.setCurso(ce);
        entity.setUsuario(ue);
        matriculaService.grabarMatricula(entity);
        return new ModelAndView("redirect:matriculaMostrar.do");
    }
}
