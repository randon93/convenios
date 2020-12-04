package com.grupo.xxiv.convenios.model.service;

import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.domain.TipoConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;

public interface TipoConvenioService {

    RespuestaGenericaDto insert(TipoConvenioDomain domain);

    RespuestaGenericaDto update(TipoConvenioDomain domain);

    RespuestaGenericaDto delete(Long id);

    RespuestaGenericaDto listAll();
}
