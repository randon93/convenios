package com.grupo.xxiv.convenios.model.service;


import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;

public interface ConvenioService {

    RespuestaGenericaDto insert(ConvenioDomain domain);

    RespuestaGenericaDto update(ConvenioDomain domain);

    RespuestaGenericaDto delete(Long id);

    RespuestaGenericaDto listAll();

    RespuestaGenericaDto findById(Long id);
}
