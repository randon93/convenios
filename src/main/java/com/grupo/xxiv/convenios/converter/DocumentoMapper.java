package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.domain.DocumentoDomain;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.entity.DocumentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DocumentoMapper {

    @Autowired
    private ModelMapper modelMapper;


    public DocumentoDomain convertToDomain(DocumentoEntity entity) {
        DocumentoDomain domain = modelMapper.map(entity, DocumentoDomain.class);
        return domain;
    }

    public DocumentoEntity convertToEntity(DocumentoDomain domain) {
        DocumentoEntity entity = modelMapper.map(domain, DocumentoEntity.class);
        return entity;
    }
}
