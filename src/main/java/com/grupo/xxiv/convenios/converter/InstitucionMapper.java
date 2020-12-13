package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.excepcion.ExcepcionDuplicidad;
import com.grupo.xxiv.convenios.message.MessageKeys;
import com.grupo.xxiv.convenios.model.domain.InstitucionDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
import common.exception.APIExceptions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Component
public class InstitucionMapper {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private RespuestaGenericaDto response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ConvenioService convenioService;

    @Autowired
    private MessageSource messageSource;


    public InstitucionDomain convertToDomain(InstitucionEntity entity) {
        List<Long> convenioDomains = new ArrayList<>();
        if (Objects.nonNull(entity.getConvenioEntities()) && !entity.getConvenioEntities().isEmpty())
            entity.getConvenioEntities().forEach(
                    ce -> convenioDomains.add(ce.getId())
            );
        InstitucionDomain domain = modelMapper.map(entity, InstitucionDomain.class);
        domain.setConvenios(convenioDomains);
        return domain;
    }

    public InstitucionEntity convertToEntity(InstitucionDomain domain) {
        List<ConvenioEntity> convenioEntities = new ArrayList<>();
        if (Objects.nonNull(domain.getConvenios()) && !domain.getConvenios().isEmpty()) {
            domain.getConvenios().forEach(
                    cd -> {
                        response = convenioService.findById(cd);
                        if (response.isEstado()) {
                            ConvenioEntity ce = (ConvenioEntity) response.getData();
                            convenioEntities.add(ce);
                        }
                    }
            );
        }
        InstitucionEntity entity = modelMapper.map(domain, InstitucionEntity.class);
        entity.setConvenioEntities(convenioEntities);
        return entity;
    }

}
