package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.domain.TipoConvenioDomain;
import com.grupo.xxiv.convenios.model.entity.TipoConvenioEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TipoConvenioMapper {

    @Autowired
    private ModelMapper modelMapper;


    public TipoConvenioDomain convertToDomain(TipoConvenioEntity entity) {
        TipoConvenioDomain domain = modelMapper.map(entity, TipoConvenioDomain.class);
        return domain;
    }

    public TipoConvenioEntity convertToEntity(TipoConvenioDomain domain) {
        TipoConvenioEntity entity = modelMapper.map(domain, TipoConvenioEntity.class);
        return entity;
    }
}
