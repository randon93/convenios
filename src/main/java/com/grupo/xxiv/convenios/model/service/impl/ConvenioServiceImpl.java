package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IConvenioDao;
import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
import common.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ConvenioServiceImpl
        extends ServiceImpl<ConvenioDomain, ConvenioEntity, Long> implements ConvenioService {

    @Autowired
    private IConvenioDao iConvenioDao;

    @Override
    protected CrudRepository<ConvenioEntity, Long> getDao() {
        return iConvenioDao;
    }
}
