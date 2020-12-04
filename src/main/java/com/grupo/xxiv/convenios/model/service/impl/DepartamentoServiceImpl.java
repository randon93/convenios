package com.grupo.xxiv.convenios.model.service.impl;

import com.grupo.xxiv.convenios.converter.DepartamentoMapper;
import com.grupo.xxiv.convenios.model.dao.IDepartamentoDao;
import com.grupo.xxiv.convenios.model.domain.DepartamentoDomain;
import com.grupo.xxiv.convenios.model.dto.RespuestaGenericaDto;
import com.grupo.xxiv.convenios.model.entity.DepartamentoEntity;
import com.grupo.xxiv.convenios.model.entity.InstitucionEntity;
import com.grupo.xxiv.convenios.model.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private IDepartamentoDao departamentoDao;

    @Autowired
    private DepartamentoMapper departamentoMapper;

    protected CrudRepository<DepartamentoEntity, Long> getDao() {
        return departamentoDao;
    }

    @Override
    public RespuestaGenericaDto insert(DepartamentoDomain domain) {
        if (Objects.isNull(domain)) {
            return RespuestaGenericaDto.error("Informacion vacia");
        }
        DepartamentoEntity e = departamentoMapper.convertToEntity(domain);
        if (Objects.isNull(e)) {
            return  RespuestaGenericaDto.error("Ocurrio un error en Converter Departamento");
        }
        Long id = getDao().save(e).getId();
        return RespuestaGenericaDto.ok(id);
    }

    @Override
    public RespuestaGenericaDto update(DepartamentoDomain domain) {
        if (!getDao().existsById(domain.getId())) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + domain.getId());
        }
        DepartamentoEntity e = departamentoMapper.convertToEntity(domain);
        return RespuestaGenericaDto.ok(getDao().save(e));
    }

    @Override
    public RespuestaGenericaDto delete(Long id) {
        DepartamentoEntity e = getDao().findById(id).orElse(null);
        if (Objects.isNull(e)) {
            return RespuestaGenericaDto.error("No se encontro la institucion " + id);
        }
        getDao().deleteById(id);
        return RespuestaGenericaDto.ok(null);
    }

    @Override
    public RespuestaGenericaDto listAll() {
        List<DepartamentoDomain> departamentos = new ArrayList<>();
        getDao().findAll().forEach(
                dd -> departamentos.add(departamentoMapper.convertToDomain(dd))
        );
        return RespuestaGenericaDto.ok(departamentos);
    }
}
