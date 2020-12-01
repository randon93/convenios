package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@RestController
@SessionAttributes("institucion")
@RequestMapping("/institucion")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @PostMapping("/insert")
    @ResponseBody
    public Long insertInstitucion(@RequestBody @Validated InstitucionEntity institucionEntity) {
        return null;
    }

    @GetMapping()
    @ResponseBody
    public List<InstitucionEntity> getInstituciones() {
        return null;
    }

    @GetMapping("/correo/{correo}")
    @ResponseBody
    public InstitucionEntity getInstitucionByCorreo(@PathVariable String correo){
        return null;
    }

    @GetMapping("/nombre/{nombre}")
    @ResponseBody
    public InstitucionEntity getnstitucionByNombre(@PathVariable String nombre) {
        return null;
    }
}
