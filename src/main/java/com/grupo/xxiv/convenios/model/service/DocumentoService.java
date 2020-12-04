package com.grupo.xxiv.convenios.model.service;

import com.grupo.xxiv.convenios.model.domain.DocumentoDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;

public interface DocumentoService {

    RespuestaGenericaDto insert(DocumentoDomain domain);

    RespuestaGenericaDto update(DocumentoDomain domain);

    RespuestaGenericaDto delete(Long id);

    RespuestaGenericaDto listAll();
}
