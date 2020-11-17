package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IInstitucionDao;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.Institucion;
import com.grupo.xxiv.convenios.model.enums.MensajeRespuestaGenerico;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class InstitucionServiceImpl implements InstitucionService {

    @Autowired
    private IInstitucionDao iInstitucionDao;

    @Override
    public RespuestaGenericaDto findById(Long id) {
        Institucion respuesta = iInstitucionDao.findById(id).orElse(null);
        if (Objects.isNull(respuesta)) {
            return RespuestaGenericaDto.builder()
                    .estado(true)
                    .mensaje(MensajeRespuestaGenerico.EXITO.toString())
                    .data(respuesta)
                    .build();
        }
        return RespuestaGenericaDto.builder()
                .estado(false)
                .mensaje(MensajeRespuestaGenerico.FRACASO.toString())
                .data(respuesta)
                .build();
    }

    @Override
    public Institucion save(Institucion institucion) {
        return iInstitucionDao.save(institucion);
    }

    @Override
    public Institucion findByNombre(String nombre) {
        return iInstitucionDao.findByNombre(nombre);
    }

    @Override
    public Institucion findByCorreo(String correo) {
        return iInstitucionDao.findByCorreo(correo);
    }

    @Override
    public List<Institucion> findAll() {
        return iInstitucionDao.findAll();
    }
}
