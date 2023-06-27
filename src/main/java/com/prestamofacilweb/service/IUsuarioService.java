package com.prestamofacilweb.service;

import java.util.List;

import com.prestamofacilweb.dto.UsuarioDTO;

public interface IUsuarioService {
    public List<UsuarioDTO> GetAll();
    public UsuarioDTO Create(UsuarioDTO request);
}
