package com.grupo.xxiv.convenios.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "documento")
@Entity
@Data
public class DocumentoEntity extends common.types.Entity<Long> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String data;

    @ManyToOne(fetch = FetchType.LAZY)
    private ConvenioEntity convenioEntity;
}
