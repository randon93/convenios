package com.grupo.xxiv.convenios.model.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "convenio")
@Entity
@Data
public class ConvenioEntity implements Serializable {

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

    @ManyToOne(fetch = FetchType.LAZY)
    private TipoConvenioEntity tipoConvenio;

    @OneToMany(mappedBy = "convenioEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DocumentoEntity> documentoEntity;

}
