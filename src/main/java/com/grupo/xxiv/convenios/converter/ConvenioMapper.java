package com.grupo.xxiv.convenios.converter;

import com.grupo.xxiv.convenios.model.dao.IDepartamentoDao;
import com.grupo.xxiv.convenios.model.dao.IDocumentoDao;
import com.grupo.xxiv.convenios.model.dao.IInstitucionDao;
import com.grupo.xxiv.convenios.model.dao.TipoConvenioDao;
import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.entity.DocumentoEntity;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.entity.TipoConvenioEntity;
import com.grupo.xxiv.convenios.model.service.DepartamentoService;
import com.grupo.xxiv.convenios.model.service.InstitucionService;
import com.grupo.xxiv.convenios.model.service.TipoConvenioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ConvenioMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDocumentoDao documentoService;

    @Autowired
    private IDepartamentoDao departamentoService;

    @Autowired
    private IInstitucionDao institucionService;

    @Autowired
    private TipoConvenioDao tipoConvenioService;


    public ConvenioDomain convertToDomain(ConvenioEntity entity) {
        List<Long> documentoDomains = new ArrayList<>();
        entity.getDocumentoEntity().forEach(
                de -> documentoDomains.add(de.getId())
        );
        ConvenioDomain domain = modelMapper.map(entity, ConvenioDomain.class);
        domain.setDepartamentoDomain(entity.getDepartamentoEntity().getId());
        domain.setInstitucionDomain(entity.getInstitucionEntity().getId());
        domain.setTipoConvenioDomain(entity.getTipoConvenio().getId());
        return domain;
    }

    public ConvenioEntity convertToEntity(ConvenioDomain domain) {
        List<DocumentoEntity> documentoEntities = new ArrayList<>();
        domain.getDocumentoDomains().forEach(
                dd -> {
                    DocumentoEntity de = documentoService.findById(dd).orElse(null);
                    if (Objects.nonNull(de)) {
                        documentoEntities.add(de);
                    }
                }
        );
        ConvenioEntity entity = modelMapper.map(domain, ConvenioEntity.class);
        DepartamentoEntity de = departamentoService.findById(domain.getId()).orElse(null);
        entity.setDepartamentoEntity(de);
        InstitucionEntity ie = institucionService.findById(domain.getInstitucionDomain()).orElse(null);
        entity.setInstitucionEntity(ie);
        TipoConvenioEntity tce = tipoConvenioService.findById(domain.getTipoConvenioDomain()).orElse(null);
        entity.setTipoConvenio(tce);
        return entity;
    }
}
