package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/institucion")
public class InstitucionController {

    @Autowired
    private InstitucionService institucionService;

    @DeleteMapping("{id}")
    @ResponseBody
    public RespuestaGenericaDto delete(@PathVariable String id) {
        return institucionService.delete(Long.parseLong(id));
    }

    @PutMapping
    @ResponseBody
    public RespuestaGenericaDto update(@RequestBody InstitucionDomain domain) {
        return institucionService.update(domain);
    }

    @PostMapping("/save")
    @ResponseBody
    public RespuestaGenericaDto save(@RequestBody InstitucionDomain domain) {
       return institucionService.insert(domain);
    }

    @GetMapping
    @ResponseBody
    public RespuestaGenericaDto getAll() {
        return institucionService.listAll();
    }

}
