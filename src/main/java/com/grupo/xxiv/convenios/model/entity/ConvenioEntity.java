package com.grupo.xxiv.convenios.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "convenio")
@Entity
@Data
public class ConvenioEntity extends common.types.Entity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    private InstitucionEntity institucionEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private DepartamentoEntity departamentoEntity;

    private TipoConvenio tipoConvenio;

}
