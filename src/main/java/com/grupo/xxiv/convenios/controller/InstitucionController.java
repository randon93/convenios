package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institucion")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @GetMapping("/correo/{correo}")
    @ResponseBody
    public InstitucionEntity getInstitucionByCorreo(@PathVariable String correo) {
        return null;
    }

    @GetMapping("/nombre/{nombre}")
    @ResponseBody
    public InstitucionEntity getnstitucionByNombre(@PathVariable String nombre) {
        return null;
    }


}
