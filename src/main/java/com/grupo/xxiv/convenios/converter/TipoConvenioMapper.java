package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.dao.IConvenioDao;
import com.grupo.xxiv.convenios.model.domain.TipoConvenioDomain;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.entity.TipoConvenioEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TipoConvenioMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IConvenioDao iConvenioDao;


    public TipoConvenioDomain convertToDomain(TipoConvenioEntity entity) {
        List<Long> convenios = new ArrayList<>();
        entity.getConvenioEntities().forEach(
                ce -> convenios.add(ce.getId())
        );
        TipoConvenioDomain domain = modelMapper.map(entity, TipoConvenioDomain.class);
        domain.setConvenios(convenios);
        return domain;
    }

    public TipoConvenioEntity convertToEntity(TipoConvenioDomain domain) {
        List<ConvenioEntity> convenioEntities = new ArrayList<>();
        domain.getConvenios().forEach(
                cd -> {
                    ConvenioEntity ce = iConvenioDao.findById(cd).orElse(null);
                    convenioEntities.add(ce);
                }
        );
        TipoConvenioEntity entity = modelMapper.map(domain, TipoConvenioEntity.class);
        entity.setConvenioEntities(convenioEntities);
        return entity;
    }
}
