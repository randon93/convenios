package com.grupo.xxiv.convenios.model.service;

import com.grupo.xxiv.convenios.model.entity.Institucion;

import java.util.List;

public interface InstitucionService {

     Institucion findById(Long id);

     List<Institucion> findByNombreLikeIgnoreCase(String name);

     Institucion save(Institucion accesorio);

     Institucion findByNumInventario(String serial);

     List<Institucion> findAll();


}
