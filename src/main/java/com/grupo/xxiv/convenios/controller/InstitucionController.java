package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.entity.Institucion;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("institucion")
@RequestMapping("/institucion")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @PostMapping("/insert")
    @ResponseBody
    public Long insertInstitucion(@RequestBody @Validated Institucion institucion) {
        return institucionService.save(institucion).getId();
    }
}
