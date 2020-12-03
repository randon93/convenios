package com.grupo.xxiv.convenios.model.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Table(name = "departamento")
@Entity
@Data
public class DepartamentoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String encargado;

    @OneToMany(mappedBy = "departamentoEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ConvenioEntity>convenioEntities;
}
