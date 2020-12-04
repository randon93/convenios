package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.model.dao.IDocumentoDao;
import com.grupo.xxiv.convenios.model.domain.DocumentoDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.DocumentoEntity;
import com.grupo.xxiv.convenios.model.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private IDocumentoDao iDocumentoDao;

    protected CrudRepository<DocumentoEntity, Long> getDao() {
        return iDocumentoDao;
    }

    @Override
    public RespuestaGenericaDto insert(DocumentoDomain domain) {
        return null;
    }

    @Override
    public RespuestaGenericaDto update(DocumentoDomain domain) {
        return null;
    }

    @Override
    public RespuestaGenericaDto delete(Long id) {
        return null;
    }

    @Override
    public RespuestaGenericaDto listAll() {
        return null;
    }
}
