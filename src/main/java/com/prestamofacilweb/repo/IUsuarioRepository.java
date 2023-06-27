package com.prestamofacilweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prestamofacilweb.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
