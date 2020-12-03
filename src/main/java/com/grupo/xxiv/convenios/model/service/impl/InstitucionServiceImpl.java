package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IInstitucionDao;
import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class InstitucionServiceImpl implements InstitucionService {

    @Autowired
    private IInstitucionDao iInstitucionDao;

    protected CrudRepository<InstitucionEntity, Long> getDao() {
        return iInstitucionDao;
    }

    @Override
    public RespuestaGenericaDto insert(InstitucionDomain domain) {

        return null;
    }

    @Override
    public RespuestaGenericaDto update(InstitucionDomain domain) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public RespuestaGenericaDto listAll() {
        return null;
    }
}
