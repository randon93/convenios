package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
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
@RequestMapping("/convenios")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;


    @DeleteMapping("{id}")
    @ResponseBody
    public RespuestaGenericaDto delete(@PathVariable String id) {
        return convenioService.delete(Long.parseLong(id));
    }

    @PutMapping
    @ResponseBody
    public RespuestaGenericaDto update(@RequestBody ConvenioDomain domain) {
        return convenioService.update(domain);
    }

    @PostMapping("/save")
    @ResponseBody
    public RespuestaGenericaDto save(@RequestBody ConvenioDomain domain) {
        return convenioService.insert(domain);
    }

    @GetMapping
    @ResponseBody
    public RespuestaGenericaDto getAll() {
        return convenioService.listAll();
    }
}
