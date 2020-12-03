package com.grupo.xxiv.convenios.model.domain;

import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import common.types.DomainBean;
import lombok.Data;

import java.util.List;

@Data
public class InstitucionDomain extends DomainBean<Long> {

    private Long id;

    private String nombre;

    private String correo;

    private String direccion;

    private String telefono;

    private List<ConvenioDomain> convenioEntities;

}
