package com.prestamofacilweb.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamofacilweb.dto.ClienteDTO;
import com.prestamofacilweb.model.Cliente;
import com.prestamofacilweb.repo.IClienteRepository;
import com.prestamofacilweb.service.IClienteService;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository _repository;

    @Autowired
    private ModelMapper _modelMapper;

    @Override
    public List<ClienteDTO> GetAllByUsuarioId(Long usuarioId) {
        List<Cliente> result = _repository.findByUsuarioId(usuarioId);
        List<ClienteDTO> list = _modelMapper.map(result, new TypeToken<List<ClienteDTO>>() {}.getType());
        return list;
    }

    @Override
    public ClienteDTO Create(ClienteDTO request) {
        Cliente entity = _modelMapper.map(request, Cliente.class);
        entity = _repository.save(entity);
        return _modelMapper.map(entity, ClienteDTO.class);
    }
}
