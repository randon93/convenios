package com.grupo.xxiv.convenios.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "convenio")
@Entity
@Data
public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Institucion institucion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento departamento;

    private TipoConvenio tipoConvenio;

}
