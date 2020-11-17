package com.grupo.xxiv.convenios.model.service;

import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.Institucion;

import java.util.List;

public interface InstitucionService {

    RespuestaGenericaDto findById(Long id);

    Institucion save(Institucion accesorio);

    Institucion findByNombre(String nombre);

    Institucion findByCorreo(String correo);

    List<Institucion> findAll();


}
