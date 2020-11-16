package com.grupo.xxiv.convenios.model.dao;

import com.grupo.xxiv.convenios.model.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentoDao extends JpaRepository<Documento, Long> {
}
