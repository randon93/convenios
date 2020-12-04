package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/departamento"})
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @DeleteMapping("{id}")
    @ResponseBody
    public RespuestaGenericaDto delete(@PathVariable String id) {
        return departamentoService.delete(Long.parseLong(id));
    }

    @PutMapping
    @ResponseBody
    public RespuestaGenericaDto update(@RequestBody DepartamentoDomain domain) {
        return departamentoService.update(domain);
    }

    @PostMapping("/save")
    @ResponseBody
    public RespuestaGenericaDto save(@RequestBody DepartamentoDomain domain) {
        return departamentoService.insert(domain);
    }

    @GetMapping
    @ResponseBody
    public RespuestaGenericaDto getAll() {
        return departamentoService.listAll();
    }
}
