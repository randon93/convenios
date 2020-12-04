package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.domain.DocumentoDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.service.DocumentoService;
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
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;


    @DeleteMapping("{id}")
    @ResponseBody
    public RespuestaGenericaDto delete(@PathVariable String id) {
        return documentoService.delete(Long.parseLong(id));
    }

    @PutMapping
    @ResponseBody
    public RespuestaGenericaDto update(@RequestBody DocumentoDomain domain) {
        return documentoService.update(domain);
    }

    @PostMapping("/save")
    @ResponseBody
    public RespuestaGenericaDto save(@RequestBody DocumentoDomain domain) {
        return documentoService.insert(domain);
    }

    @GetMapping
    @ResponseBody
    public RespuestaGenericaDto getAll() {
        return documentoService.listAll();
    }
}
