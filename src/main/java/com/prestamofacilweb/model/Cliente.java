package com.prestamofacilweb.model;

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
public class Cliente {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clienteId;

    @Column(nullable = false)
    private Long tipoId;

    @Column(nullable = false, length = 50)
    private String identificacion;

    @Column(nullable = false, length = 500)
    private String nombreCompleto;

    @Column(nullable = false)
    private Long generoId;

    @Column(nullable = false, length = 300)
    private String direccion;

    @Column(nullable = false, length = 100)
    private String telCel;

    @Column(nullable = false)
    private Long estadoId;

    @ManyToOne
	@JoinColumn(name = "usuarioId", nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_CLIENTE"))
	private Usuario usuario;

}
