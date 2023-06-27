package com.prestamofacilweb.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prestamofacilweb.dto.UsuarioDTO;
import com.prestamofacilweb.model.Usuario;
import com.prestamofacilweb.repo.IUsuarioRepository;
import com.prestamofacilweb.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository _repository;

    @Autowired
    private ModelMapper _modelMapper;

    @Override
    public List<UsuarioDTO> GetAll() {
        List<Usuario> result = _repository.findAll();
        return _modelMapper.map(result, new TypeToken<List<UsuarioDTO>>() {}.getType());
    }

    @Override
    public UsuarioDTO Create(UsuarioDTO request) {
        Usuario entity = _modelMapper.map(request, Usuario.class);
        entity.setClave("123456");
        entity = _repository.save(entity);
        return _modelMapper.map(entity, UsuarioDTO.class);
    }
}
