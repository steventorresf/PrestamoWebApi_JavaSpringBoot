package com.prestamofacilweb.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteDTO {
    private Long ClienteId;
    private Long UsuarioId;
    private Long TipoId;

    @NotBlank
    private String Identificacion;

    @NotBlank
    private String NombreCompleto;
    
    private Long GeneroId;

    @NotBlank
    private String Direccion;

    @NotBlank
    private String TelCel;

    private Long EstadoId;

    private UsuarioDTO Usuario;
}
