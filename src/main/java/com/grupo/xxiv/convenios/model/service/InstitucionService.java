package com.grupo.xxiv.convenios.model.service;

import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;

import java.util.List;

public interface InstitucionService {

    RespuestaGenericaDto insert(InstitucionDomain domain);

    RespuestaGenericaDto update(InstitucionDomain domain);

    void delete(Long id);

    RespuestaGenericaDto listAll();

}
