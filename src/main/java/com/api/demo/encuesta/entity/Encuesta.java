package com.api.demo.encuesta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Encuesta")
@Getter
@Setter
public class Encuesta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_encuesta")
	private Long id;

	@Column(name = "estilo_musical")
	private String estiloMusical;
	
	//@Email(message = "email invalido")
	//@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Email debe ser valido")
	@Column(name = "email", unique = true)
	private String email;
}