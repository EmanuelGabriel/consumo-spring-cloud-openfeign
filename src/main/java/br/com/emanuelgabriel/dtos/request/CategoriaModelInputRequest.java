package br.com.emanuelgabriel.dtos.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaModelInputRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String descricao;

}
