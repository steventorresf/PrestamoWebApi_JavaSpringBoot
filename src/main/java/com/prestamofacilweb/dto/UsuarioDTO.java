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
public class UsuarioDTO {
    private Long usuarioId;

    @NotBlank
    private String nombreCompleto;

    @NotBlank
    private String nombreUsuario;

    @NotBlank
    private String avatar;
}
