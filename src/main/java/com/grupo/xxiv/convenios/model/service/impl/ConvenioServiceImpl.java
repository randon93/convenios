package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.converter.ConvenioMapper;
import com.grupo.xxiv.convenios.model.dao.IConvenioDao;
import com.grupo.xxiv.convenios.model.domain.ConvenioDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.service.ConvenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ConvenioServiceImpl implements ConvenioService {

    @Autowired
    private IConvenioDao iConvenioDao;

    @Autowired
    private ConvenioMapper convenioMapper;

    protected JpaRepository<ConvenioEntity, Long> getDao() {
        return iConvenioDao;
    }

    @Override
    public RespuestaGenericaDto insert(ConvenioDomain domain) {
        if (Objects.isNull(domain)) {
            return RespuestaGenericaDto.error("Informacion vacia");
        }
        ConvenioEntity e = convenioMapper.convertToEntity(domain);
        if (Objects.isNull(e)) {
            return  RespuestaGenericaDto.error("Ocurrio un error en Converter Departamento");
        }
        Long id = getDao().save(e).getId();
        return RespuestaGenericaDto.ok(id);
    }

    @Override
    public RespuestaGenericaDto update(ConvenioDomain domain) {
        if (!getDao().existsById(domain.getId())) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + domain.getId());
        }
        ConvenioEntity e = convenioMapper.convertToEntity(domain);
        return RespuestaGenericaDto.ok(getDao().save(e));
    }

    @Override
    public RespuestaGenericaDto delete(Long id) {
        ConvenioEntity e = getDao().findById(id).orElse(null);
        if (Objects.isNull(e)) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + id);
        }
        getDao().deleteById(id);
        return RespuestaGenericaDto.ok(null);
    }

    @Override
    public RespuestaGenericaDto listAll() {
        List<ConvenioDomain> convenioDomains = new ArrayList<>();
        List<ConvenioEntity> convenioEntities = getDao().findAll();
        convenioEntities.forEach(
                ce -> {
                    ConvenioDomain d = convenioMapper.convertToDomain(ce);
                    convenioDomains.add(d);
                }
        );
        return RespuestaGenericaDto.ok(convenioDomains);
    }

    @Override
    public RespuestaGenericaDto listAll(Pageable pageRequest) {
        Page<ConvenioEntity> convenios = (Page) getDao().findAll(pageRequest).getContent();
        return RespuestaGenericaDto.ok(convenios);
    }

    @Override
    public RespuestaGenericaDto findById(Long id) {
        ConvenioEntity ce = iConvenioDao.findById(id).orElse(null);
        if (Objects.isNull(ce)) {
            return RespuestaGenericaDto.error("No se encontro Convenio");
        }
        return RespuestaGenericaDto.ok(ce);
    }

}
