package com.grupo.xxiv.convenios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("departamento")
@RequestMapping({"/departamento", "/"})
public class DepartamentoController {

}
