package com.grupo.xxiv.convenios.model.service;


import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;

import java.util.List;

public interface ConvenioService {

    RespuestaGenericaDto insert(ConvenioDomain domain);

    RespuestaGenericaDto update(ConvenioDomain domain);

    void delete(Long id);

    RespuestaGenericaDto listAll();
}
