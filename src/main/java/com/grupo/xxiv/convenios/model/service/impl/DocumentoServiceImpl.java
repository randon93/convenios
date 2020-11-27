package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IDocumentoDao;
import com.grupo.xxiv.convenios.model.domain.DocumentoDomain;
import com.grupo.xxiv.convenios.model.entity.DocumentoEntity;
import com.grupo.xxiv.convenios.model.service.DocumentoService;
import common.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class DocumentoServiceImpl
        extends ServiceImpl<DocumentoDomain, DocumentoEntity, Long>
        implements DocumentoService {

    @Autowired
    private IDocumentoDao iDocumentoDao;

    @Override
    protected CrudRepository<DocumentoEntity, Long> getDao() {
        return iDocumentoDao;
    }
}
