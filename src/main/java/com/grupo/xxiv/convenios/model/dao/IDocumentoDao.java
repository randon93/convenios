package com.grupo.xxiv.convenios.model.dao;

import com.grupo.xxiv.convenios.model.entity.DocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentoDao extends JpaRepository<DocumentoEntity, Long> {
}
