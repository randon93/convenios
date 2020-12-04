package com.grupo.xxiv.convenios.model.service;

import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;

public interface DepartamentoService {

    RespuestaGenericaDto insert(DepartamentoDomain domain);

    RespuestaGenericaDto update(DepartamentoDomain domain);

    RespuestaGenericaDto delete(Long id);

    RespuestaGenericaDto listAll();
}
