package com.grupo.xxiv.convenios.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaGenericaDto {

    private String mensaje;
    private boolean estado;
    private Object data;

}
