package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.service.DepartamentoService;
import common.controller.ControllerImpl;
import common.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping({"/departamento"})
public class DepartamentoController extends ControllerImpl<DepartamentoDomain, Long> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    public Service<DepartamentoDomain, Long> getService() {
        return departamentoService;
    }
}
