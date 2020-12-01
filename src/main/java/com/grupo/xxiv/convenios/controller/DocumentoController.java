package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.domain.DocumentoDomain;
import com.grupo.xxiv.convenios.model.filter.DocumentoFilter;
import com.grupo.xxiv.convenios.model.service.DocumentoService;
import common.controller.ControllerImpl;
import common.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documento")
public class DocumentoController extends ControllerImpl<DocumentoDomain, Long> {

    @Autowired
    private DocumentoService documentoService;

    @Override
    public Service<DocumentoDomain, Long> getService() {
        return documentoService;
    }
}
