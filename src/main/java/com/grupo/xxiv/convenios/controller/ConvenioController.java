package com.grupo.xxiv.convenios.controller;

import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.filter.ConvenioFilter;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
import common.controller.ControllerImpl;
import common.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convenios")
public class ConvenioController extends ControllerImpl<ConvenioDomain, Long> {

    @Autowired
    private ConvenioService convenioService;

    @Override
    public Service<ConvenioDomain, Long> getService() {
        return null;
    }
}
