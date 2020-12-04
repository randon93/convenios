package com.grupo.xxiv.convenios.model.domain;

import com.grupo.xxiv.convenios.model.entity.ConvenioEntity;
import common.types.DomainBean;
import lombok.Data;

@Data
public class DocumentoDomain extends DomainBean<Long> {

    private Long id;

    private String nombre;

    private String data;

    private Long convenioDomain;
}
