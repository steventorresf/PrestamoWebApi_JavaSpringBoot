package com.prestamofacilweb.service;

import java.util.List;

import com.prestamofacilweb.dto.ClienteDTO;

public interface IClienteService {
    public List<ClienteDTO> GetAllByUsuarioId(Long usuarioId);
    public ClienteDTO Create(ClienteDTO request);
}
