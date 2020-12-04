package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.converter.InstitucionMapper;
import com.grupo.xxiv.convenios.model.dao.IInstitucionDao;
import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class InstitucionServiceImpl implements InstitucionService {

    @Autowired
    private IInstitucionDao iInstitucionDao;

    @Autowired
    private InstitucionMapper institucionMapper;

    protected CrudRepository<InstitucionEntity, Long> getDao() {
        return iInstitucionDao;
    }

    @Override
    public RespuestaGenericaDto insert(InstitucionDomain domain) {
        if (Objects.isNull(domain)) {
            return RespuestaGenericaDto.error("Informacion vacia");
        }
        InstitucionEntity e = institucionMapper.convertToEntity(domain);
        if (Objects.isNull(e)) {
            return  RespuestaGenericaDto.error("Ocurrio un error en Converter Institucion");
        }
        Long id = getDao().save(e).getId();
        return RespuestaGenericaDto.ok(id);
    }

    @Override
    public RespuestaGenericaDto update(InstitucionDomain domain) {
        if (!getDao().existsById(domain.getId())) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + domain.getId());
        }
        InstitucionEntity e = institucionMapper.convertToEntity(domain);
        return RespuestaGenericaDto.ok(getDao().save(e));
    }

    @Override
    public RespuestaGenericaDto delete(Long id) {
        InstitucionEntity e = getDao().findById(id).orElse(null);
        if (Objects.isNull(e)) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + id);
        }
        getDao().deleteById(id);
        return RespuestaGenericaDto.ok(null);
    }

    @Override
    public RespuestaGenericaDto listAll() {
        List<InstitucionDomain> institucionDomains = new ArrayList<>();
        getDao().findAll().forEach(
                id -> institucionDomains.add(institucionMapper.convertToDomain(id))
        );
        return RespuestaGenericaDto.ok(institucionDomains);
    }
}
