package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IConvenioDao;
import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConvenioServiceImpl implements ConvenioService {

    @Autowired
    private IConvenioDao iConvenioDao;

    protected CrudRepository<ConvenioEntity, Long> getDao() {
        return iConvenioDao;
    }

    @Override
    public RespuestaGenericaDto insert(ConvenioDomain domain) {
        return null;
    }

    @Override
    public RespuestaGenericaDto update(ConvenioDomain domain) {
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
