package br.com.emanuelgabriel.service;

import java.util.List;

import br.com.emanuelgabriel.service.exception.CategoriaNaoEncontradaException;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.emanuelgabriel.dtos.request.CategoriaModelInputRequest;
import br.com.emanuelgabriel.model.CategoriaModelResponse;

@FeignClient(name = "categorias", url = "${uri.api.base}")
public interface Categoria {

	@PostMapping(value = "/categorias")
	CategoriaModelResponse criar(CategoriaModelResponse categoria);

	@PostMapping(value = "/categorias")
	CategoriaModelResponse criar(CategoriaModelInputRequest request) throws FeignException;

	@GetMapping(value = "/categorias")
	List<CategoriaModelResponse> getCategorias() throws FeignException;

	@GetMapping(value = "/categorias/{codigoCategoria}")
	CategoriaModelResponse buscarPorID(@PathVariable Long codigoCategoria) throws FeignException;

}
