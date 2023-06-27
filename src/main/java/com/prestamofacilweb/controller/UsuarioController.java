package com.prestamofacilweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prestamofacilweb.dto.UsuarioDTO;
import com.prestamofacilweb.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService _service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> GetAll(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<List<UsuarioDTO>>(_service.GetAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> Create(@RequestHeader HttpHeaders headers, @RequestBody UsuarioDTO body) {
        return new ResponseEntity<UsuarioDTO>(_service.Create(body), HttpStatus.OK);
    }

}
