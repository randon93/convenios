package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DepartamentoMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConvenioService convenioService;

    private RespuestaGenericaDto response;


    public DepartamentoDomain convertToDomain(DepartamentoEntity entity) {
        List<Long> convenioDomains = new ArrayList<>();
        entity.getConvenioEntities().forEach(
                ce -> convenioDomains.add(ce.getId())
        );
        DepartamentoDomain domain = modelMapper.map(entity, DepartamentoDomain.class);
        domain.setConvenios(convenioDomains);
        return domain;
    }

    public DepartamentoEntity convertToEntity(DepartamentoDomain domain) {
        List<ConvenioEntity> convenioEntities = new ArrayList<>();
        if (Objects.nonNull(domain.getConvenios()) && !domain.getConvenios().isEmpty()) {
            domain.getConvenios().forEach(
                    cd -> {
                        response = convenioService.findById(cd);
                        if (response.isEstado()){
                            ConvenioEntity ce =(ConvenioEntity) response.getData();
                            convenioEntities.add(ce);
                        }
                    }
            );
        }
        DepartamentoEntity entity = modelMapper.map(domain, DepartamentoEntity.class);
        entity.setConvenioEntities(convenioEntities);
        return entity;
    }
}
