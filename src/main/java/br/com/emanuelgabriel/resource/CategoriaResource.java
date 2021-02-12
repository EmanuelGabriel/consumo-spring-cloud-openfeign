package br.com.emanuelgabriel.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.emanuelgabriel.dtos.request.CategoriaModelInputRequest;
import br.com.emanuelgabriel.model.CategoriaModelResponse;
import br.com.emanuelgabriel.service.Categoria;
import br.com.emanuelgabriel.service.exception.CategoriaNaoEncontradaException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Categorias", description = "Gerencia as categorias")
@RestController
@RequestMapping(value = "/api/v1/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaResource {

	@Autowired
	Categoria categoria;

	@Operation(description = "Listar as categorias", summary = "Listar as categorias")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "401", description = "Não autorizado"),
			@ApiResponse(responseCode = "404", description = "Nenhum registro encontrado"),
			@ApiResponse(responseCode = "500", description = "O servidor encontrou um erro não previsto") })
	@GetMapping
	public ResponseEntity<List<CategoriaModelResponse>> findAll() {
		List<CategoriaModelResponse> categorias = this.categoria.getCategorias();
		return ResponseEntity.ok().body(categorias);
	}

	@Operation(description = "Cadastra uma categoria", summary = "Cadastra uma categoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Nova categoria criada com sucesso"),
			@ApiResponse(responseCode = "401", description = "Não autorizado"),
			@ApiResponse(responseCode = "500", description = "O servidor encontrou um erro não previsto") })
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CategoriaModelResponse> salvar(@RequestBody CategoriaModelInputRequest request) {
		this.categoria.criar(request);
		URI location = getUri(request.getNome());
		return ResponseEntity.created(location).build();
	}

	@Operation(description = "Busca uma categoria por ID", summary = "Busca uma categoria por ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "401", description = "Não autorizado"),
			@ApiResponse(responseCode = "404", description = "Nenhum registro encontrado"),
			@ApiResponse(responseCode = "500", description = "O servidor encontrou um erro não previsto") })
	@GetMapping(value = "/{codigoCategoria}")
	public CategoriaModelResponse buscarPorID(@PathVariable Long codigoCategoria) {
		CategoriaModelResponse categoria = this.categoria.buscarPorID(codigoCategoria);
		if (categoria == null) {
			throw new CategoriaNaoEncontradaException("Categoria de código não encontrado");
		}
		return categoria;
	}

	private URI getUri(String nome) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{nome}").buildAndExpand(nome).toUri();
	}

}
