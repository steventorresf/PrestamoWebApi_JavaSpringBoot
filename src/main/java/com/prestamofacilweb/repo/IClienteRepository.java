package com.prestamofacilweb.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prestamofacilweb.model.Cliente;


public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("from Cliente c WHERE c.usuario.usuarioId = :uid")
    List<Cliente> findByUsuarioId(@Param("uid") Long usuarioId);
}
