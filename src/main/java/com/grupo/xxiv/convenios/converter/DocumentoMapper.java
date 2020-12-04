package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.dao.IConvenioDao;
import com.grupo.xxiv.convenios.model.dao.TipoConvenioDao;
import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.domain.DocumentoDomain;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.entity.DocumentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentoMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IConvenioDao convenioDao;


    public DocumentoDomain convertToDomain(DocumentoEntity entity) {
        DocumentoDomain domain = modelMapper.map(entity, DocumentoDomain.class);
        domain.setConvenioDomain(entity.getConvenioEntity().getId());
        return domain;
    }

    public DocumentoEntity convertToEntity(DocumentoDomain domain) {
        DocumentoEntity entity = modelMapper.map(domain, DocumentoEntity.class);
        ConvenioEntity ce = convenioDao.findById(domain.getConvenioDomain()).orElse(null);
        entity.setConvenioEntity(ce);
        return entity;
    }
}
