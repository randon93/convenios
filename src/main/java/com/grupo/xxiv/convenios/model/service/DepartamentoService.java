package com.grupo.xxiv.convenios.model.service;

import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;

import java.util.List;

public interface DepartamentoService {

    RespuestaGenericaDto insert(DepartamentoDomain domain);

    RespuestaGenericaDto update(DepartamentoDomain domain);

    void delete(Long id);

    RespuestaGenericaDto listAll();
}
