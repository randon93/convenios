package com.grupo.xxiv.convenios.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaGenericaDto {

    private String mensaje;
    private boolean estado;
    private Object data;

    public static RespuestaGenericaDto ok(Object data){
        return  RespuestaGenericaDto.builder()
                .data(data)
                .estado(true)
                .mensaje("EXITO")
                .build();
    }

    public static RespuestaGenericaDto error(String mensaje){
        return  RespuestaGenericaDto.builder()
                .data(null)
                .estado(false)
                .mensaje(mensaje)
                .build();
    }
}
