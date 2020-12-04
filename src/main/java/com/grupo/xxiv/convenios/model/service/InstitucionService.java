package com.grupo.xxiv.convenios.model.service;

import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;

public interface InstitucionService {

    RespuestaGenericaDto insert(InstitucionDomain domain);

    RespuestaGenericaDto update(InstitucionDomain domain);

    RespuestaGenericaDto delete(Long id);

    RespuestaGenericaDto listAll();

}
