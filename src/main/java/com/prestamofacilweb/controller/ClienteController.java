package com.prestamofacilweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamofacilweb.dto.ClienteDTO;
import com.prestamofacilweb.dto.ResponseData;
import com.prestamofacilweb.dto.exceptions.UnauthorizedException;
import com.prestamofacilweb.service.IClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService _service;

    @Operation(summary = "Listado de todos los clientes activos de un usuario", parameters = {
            @Parameter(in = ParameterIn.HEADER, name = "Authorization", description = "Jwt - Ejemplo: Bearer {token}", schema = @Schema(type = "string")),
            @Parameter(in = ParameterIn.HEADER, name = "uid", description = "User Id", schema = @Schema(type = "integer"), required = true)
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData<List<ClienteDTO>> GetAll(@RequestHeader HttpHeaders headers) {
        if (headers.get("uid") == null)
            throw new UnauthorizedException("El 'uid' es requerido");

        List<ClienteDTO> listado = _service.GetAllByUsuarioId(Long.parseLong(headers.getFirst("uid")));
        ResponseData<List<ClienteDTO>> response = new ResponseData<List<ClienteDTO>>(listado);
        return response;
    }

    @Operation(summary = "Crea un cliente nuevo de un usuario específico", parameters = {
            @Parameter(in = ParameterIn.HEADER, name = "Authorization", description = "Jwt - Ejemplo: Bearer {token}", schema = @Schema(type = "string")),
            @Parameter(in = ParameterIn.HEADER, name = "uid", description = "User Id", schema = @Schema(type = "integer"), required = true)
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData<ClienteDTO> Create(@RequestHeader HttpHeaders headers, @RequestBody ClienteDTO body) {
        ClienteDTO result = _service.Create(body);
        ResponseData<ClienteDTO> response = new ResponseData<ClienteDTO>(result,
                "El cliente ha sido creado exitosamente.");
        return response;
    }

}
