package br.com.emanuelgabriel.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CategoriaModelResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	private String nome;

}
