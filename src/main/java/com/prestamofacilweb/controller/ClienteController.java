package com.prestamofacilweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamofacilweb.dto.ClienteDTO;
import com.prestamofacilweb.dto.ResponseData;
import com.prestamofacilweb.service.IClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService _service;

    @GetMapping(produces = "application/json")
    public ResponseData<List<ClienteDTO>> GetAll(@RequestHeader HttpHeaders headers) {
        List<ClienteDTO> listado = _service.GetAllByUsuarioId(Long.parseLong(headers.getFirst("uid")));
        ResponseData<List<ClienteDTO>> response = new ResponseData<List<ClienteDTO>>(listado);
        return response;
    }

    @PostMapping(produces = "application/json")
    public ResponseData<ClienteDTO> Create(@RequestHeader HttpHeaders headers, @RequestBody ClienteDTO body) {
        ClienteDTO result = _service.Create(body);
        ResponseData<ClienteDTO> response = new ResponseData<ClienteDTO>(result, "El cliente ha sido creado exitosamente.");
        return response;
    }

}
