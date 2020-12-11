package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
import com.grupo.xxiv.convenios.utils.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping({"/list", "/"})
    public String listAll(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

        Pageable pageRequest = PageRequest.of(page, 5);
        Page<ConvenioEntity> pageEdificio = (Page<ConvenioEntity>) convenioService.listAll(pageRequest).getData();
        PageRender<ConvenioEntity> pageRedner = new PageRender<>("", pageEdificio);
        model.addAttribute("titulo", "Listado de Convenios");
        model.addAttribute("convenios", pageEdificio);
        model.addAttribute("page", pageRedner);

        return "listarEdificio";
    }
}
