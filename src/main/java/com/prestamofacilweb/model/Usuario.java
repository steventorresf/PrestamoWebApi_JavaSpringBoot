package com.prestamofacilweb.model;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long usuarioId;

    @Column(nullable = false, length = 500)
    private String nombreCompleto;

    @Column(nullable = false, length = 50)
    private String nombreUsuario;

    @Column(nullable = false, length = 100)
    private String clave;

    @Column(nullable = false, length = 50)
    private String avatar;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Cliente> clientes;
}
